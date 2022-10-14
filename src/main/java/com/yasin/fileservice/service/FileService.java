package com.yasin.fileservice.service;

import com.yasin.fileservice.dto.ResponseFile;
import com.yasin.fileservice.entity.File;
import com.yasin.fileservice.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFile(MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.setFilename(multipartFile.getOriginalFilename());
        file.setFilesize(multipartFile.getSize());
        file.setFile(multipartFile.getBytes());
        file.setType(multipartFile.getContentType());
        file.setCreateAt(Date.from(Instant.now()));
        file.setLastModifiedDate(Date.from(Instant.now()));
        return fileRepository.save(file);
    }

    public List<ResponseFile> getAllFile(){
        return fileRepository.findAll().stream().map(file -> {
             String createdUri = createUri(file.getId());

            return new ResponseFile(createdUri,
                    file.getFilename(),
                    file.getFilesize(),
                    file.getType(),
                    file.getLastModifiedDate());
        }).collect(Collectors.toList());
    }


    public File getFileById(String id){
        return fileRepository.findById(id);
    }

    public ResponseFile updateById(String id, MultipartFile updateFile){
        File toBeUpdatedFile = fileRepository.findById(id);
        toBeUpdatedFile.setFilename(updateFile.getOriginalFilename());
        toBeUpdatedFile.setFilesize(updateFile.getSize());
        toBeUpdatedFile.setType(updateFile.getContentType());
        toBeUpdatedFile.setFile(toBeUpdatedFile.getFile());
        toBeUpdatedFile.setLastModifiedDate(java.util.Date.from(Instant.now()));

        File updatedFile = fileRepository.save(toBeUpdatedFile);

        return new ResponseFile(createUri(updatedFile.getId()),
                updatedFile.getFilename(),
                updatedFile.getFilesize(),
                updatedFile.getType(),
                updatedFile.getLastModifiedDate());

    }

    public ResponseFile deleteById(String id){
        File deletedFile = null;
        if (fileRepository.existsById(id)){
            deletedFile = fileRepository.findById(id);
            fileRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("ID is Not Found");
        }
        return new ResponseFile(null, deletedFile.getFilename(), deletedFile.getFilesize(), deletedFile.getType(), deletedFile.getLastModifiedDate());

    }

    private String createUri(String fileId){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/file/")
                .path(fileId)
                .toUriString();
    }

}
