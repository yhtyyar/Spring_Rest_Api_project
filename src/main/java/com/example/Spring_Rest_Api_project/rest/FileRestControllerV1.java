package com.example.Spring_Rest_Api_project.rest;

import com.example.Spring_Rest_Api_project.model.File;
import com.example.Spring_Rest_Api_project.service.impl.FileServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/files")
public class FileRestControllerV1 {


    private final FileServiceImpl fileService;


    @PostMapping
    public File create(@RequestBody @NonNull File file) {
        return fileService.create(file);
    }


    @PutMapping
    public File update(@RequestBody @NonNull File file) {
        return fileService.update(file);
    }


    @GetMapping
    public List<File> getAll() {
        return fileService.getAll();
    }


    @GetMapping("/{id}")
    public File get(@PathVariable("id") Long id) {
        return fileService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        fileService.deleteById(id);
    }

}
