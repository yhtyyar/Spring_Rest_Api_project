package com.example.Spring_Rest_Api_project.rest;

import com.example.Spring_Rest_Api_project.model.File;
import com.example.Spring_Rest_Api_project.service.impl.FileServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/files")
public class FileRestControllerV1 {


    private final FileServiceImpl fileService;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('files:write')")
    public File create(@RequestBody @NonNull File file) {
        return fileService.create(file);
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('files:write')")
    public File update(@RequestBody @NonNull File file) {
        return fileService.update(file);
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('files:read')")
    public List<File> getAll() {
        return fileService.getAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('files:read')")
    public File get(@PathVariable("id") Long id) {
        return fileService.getById(id);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('files:write')")
    public void delete(@PathVariable("id") Long id) {
        fileService.deleteById(id);
    }

}
