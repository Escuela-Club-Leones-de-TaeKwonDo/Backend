package com.tdi.taekwondo.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tdi.taekwondo.model.File;
import com.tdi.taekwondo.repository.FileRepository;

@Service
public class FileStorageService {
	  @Autowired
	  private FileRepository FileRepository;

	  public File store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    File FileDB = new File(fileName, file.getContentType(), file.getBytes());

	    return FileRepository.save(FileDB);
	  }

	  public File getFile(String id) {
	    return FileRepository.findById(id).get();
	  }
	  
	  public Stream<File> getAllFiles() {
	    return FileRepository.findAll().stream();
	  }
}
