package com.yasin.fileservice.controller;

import com.yasin.fileservice.dto.ResponseFile;
import com.yasin.fileservice.entity.File;
import com.yasin.fileservice.service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<File> saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        File savedFile =fileService.saveFile(file);
        return ResponseEntity.ok().body(savedFile);
    }

    @GetMapping
    public List<ResponseFile> getAllFile(){
        return fileService.getAllFile();
    }

    @GetMapping("/{id}")
     public ResponseEntity<Object> getFileById(@PathVariable String id){
        File file =fileService.getFileById(id);
        /*
        Content-Disposition: Http yanitinda icerigin tarayici icerisinde mi
        yoksa indirilecek bir ek olarak mi seklinde belirtilen kisim.
         */
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file.getFile());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseFile> updatedById(@PathVariable String id, @RequestParam("file") MultipartFile file){
        ResponseFile updatedFile = fileService.updateById(id, file);
        return ResponseEntity.ok().body(updatedFile);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFile> deleteById(@PathVariable String id){
        ResponseFile deletedFile = fileService.deleteById(id);
        return ResponseEntity.ok().body(deletedFile);
    }
}
