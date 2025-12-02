package com.practica1.carritocompras.controller;

import com.practica1.carritocompras.service.DatabaseExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private DatabaseExportService databaseExportService;

    @GetMapping("/admin/download-db-sql")
    public ResponseEntity<ByteArrayResource> downloadDatabaseSql() {
        byte[] sqlBytes = databaseExportService.exportDatabaseToSql();
        ByteArrayResource resource = new ByteArrayResource(sqlBytes);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=database_export.sql")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(sqlBytes.length)
                .body(resource);
    }
}