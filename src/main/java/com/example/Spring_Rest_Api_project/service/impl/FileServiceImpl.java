package com.example.Spring_Rest_Api_project.service.impl;

import com.example.Spring_Rest_Api_project.model.File;
import com.example.Spring_Rest_Api_project.repository.FileRepository;
import com.example.Spring_Rest_Api_project.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {


    private final FileRepository fileRepository;


    @Override
    public File create(File file) {
        log.info("Create File{}", file);
        return fileRepository.save(file);
    }

    @Override
    public File update(File file) {
        log.info("Update File{}", file);
        return fileRepository.save(file);
    }

    @Override
    public File getById(Long id) {
        log.info("Get File by ID {}", id);
        return fileRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete File by ID {}", id);
        fileRepository.deleteById(id);
    }

    @Override
    public List<File> getAll() {
        log.info("Get all files");
        return fileRepository.findAll();
    }
}
