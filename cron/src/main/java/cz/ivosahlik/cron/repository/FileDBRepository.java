package cz.ivosahlik.cron.repository;

import cz.ivosahlik.domain.FileDB;
import cz.ivosahlik.domain.FileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

    @Query("SELECT c FROM FileDB c WHERE c.status = ?1")
    List<FileDB> findAllByStatus(FileStatus status);


}