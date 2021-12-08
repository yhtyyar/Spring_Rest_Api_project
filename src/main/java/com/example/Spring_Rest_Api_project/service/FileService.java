package com.example.Spring_Rest_Api_project.service;

import com.example.Spring_Rest_Api_project.model.File;

import java.util.List;

public interface FileService {

    File create(File file);

    File update(File file);

    File getById(Long id);

    void deleteById(Long id);

    List<File> getAll();
}
