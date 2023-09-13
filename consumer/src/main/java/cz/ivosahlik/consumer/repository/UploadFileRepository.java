package cz.ivosahlik.consumer.repository;

import cz.ivosahlik.domain.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<FileDB, String> {

}