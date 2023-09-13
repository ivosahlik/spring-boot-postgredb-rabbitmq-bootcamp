package cz.ivosahlik.cron.service;

import cz.ivosahlik.clamav.CheckService;
import cz.ivosahlik.cron.repository.FileDBRepository;
import cz.ivosahlik.domain.FileDB;
import cz.ivosahlik.domain.FileStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FileCronScheduler implements CronScheduler {

    private final FileDBRepository fileDBRepository;
    private final CheckService checkService;

    @Scheduled(fixedRateString = "${file-service.scheduler-fixed-rate}",
            initialDelayString = "${file-service.scheduler-initial-delay}")
    @Override
    public void process() {

        List<FileDB> allByStatus = fileDBRepository.findAllByStatus(FileStatus.PROCESSING);

        allByStatus.forEach(fileDB -> {
            try {
                String id = fileDB.getId();
                byte[] data = fileDB.getData();
                FileStatus fileStatus = checkService.checkFile(data);
                Optional<FileDB> byId = fileDBRepository.findById(id);
                if (byId.isPresent()) {
                    FileDB fileDB1 = byId.get();
                    fileDB1.setStatus(fileStatus);
                    fileDBRepository.save(fileDB1);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
