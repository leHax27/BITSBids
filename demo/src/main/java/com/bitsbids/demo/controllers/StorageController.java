package com.bitsbids.demo.controllers;

import com.bitsbids.demo.services.storageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class StorageController {

    @Autowired
    private storageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value="file") MultipartFile file)
    {
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }
    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-Type", "application/octet-stream")
                .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        boolean deletionResult = Boolean.parseBoolean(service.deleteFile(fileName));

        if (deletionResult) {
            return ResponseEntity.ok("File deleted successfully: " + fileName);
        } else {
            return ResponseEntity.status(404).body("File not found: " + fileName);
        }
    }
}
