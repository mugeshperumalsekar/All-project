package com.ponsun.aml.banktransaction.FilesStorage.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@SpringBootApplication

public class FileDownloadUtil {

    private Path foundFile;
    private final String baseRoot = "D:\\uploadImages";


    public Resource getDocument(String customerId,String documentName) throws IOException {
        String resolvedRootDirectory = "";

        resolvedRootDirectory = "bankDocument\\Bank\\"+customerId;


        Path root = Paths.get(baseRoot, resolvedRootDirectory);

        Optional<Path> file = Files.list(root)
                .filter(f -> FilenameUtils.removeExtension(f.getFileName().toString()).equals(documentName))
                .findFirst();

        if (file.isPresent()) {
            foundFile = file.get();
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}

