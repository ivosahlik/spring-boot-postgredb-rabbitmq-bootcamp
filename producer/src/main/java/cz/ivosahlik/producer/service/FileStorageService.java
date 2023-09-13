package cz.ivosahlik.producer.service;

import cz.ivosahlik.domain.FileDB;
import cz.ivosahlik.domain.FileStatus;
import cz.ivosahlik.producer.repository.FileDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class FileStorageService {

    private final FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), FileStatus.PENDING);

        return fileDBRepository.save(FileDB);
    }


    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}