package com.example.Spring_Rest_Api_project.repository;

import com.example.Spring_Rest_Api_project.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository <File, Long> {
}
