package ru.safarov.wordspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.safarov.wordspring.service.StorageService;

@Controller
public class FileUploadController {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private StorageService storageService;

        @Autowired
        public FileUploadController(StorageService storageService) {
            this.storageService = storageService;
        }

        @GetMapping("/")
        public String listUploadedFiles(Model model) throws IOException {

            model.addAttribute("files", storageService.loadAll().map(
                    path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                            "serveFile", path.getFileName().toString()).build().toUri().toString())
                    .collect(Collectors.toList()));

            return "uploadForm";
        }

        @GetMapping("/files/{filename:.+}")
        @ResponseBody
        public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        }

        @PostMapping("/")
        public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                       RedirectAttributes redirectAttributes) {

            storageService.store(file);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");

            return "redirect:/";
        }

        @ExceptionHandler(StorageFileNotFoundException.class)
        public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
            return ResponseEntity.notFound().build();
        }

}
