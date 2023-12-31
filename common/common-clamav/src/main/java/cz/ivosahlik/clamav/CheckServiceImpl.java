package cz.ivosahlik.clamav;

import cz.ivosahlik.domain.FileStatus;
import fi.solita.clamav.ClamAVClient;

public class CheckServiceImpl implements CheckService {

    @Override
    public FileStatus checkFile(byte[] input) {
        // https://github.com/openbridge/clamav/blob/master/docker-compose.yml
        // https://github.com/cdarras/clamav-client
        // https://stackoverflow.com/questions/4721406/how-to-scan-a-file-with-antivirus-on-upload-in-java
        if (input != null) {
            boolean cleanReply = ClamAVClient.isCleanReply(input);
            if (!cleanReply) {
                return FileStatus.CANCELLED;
            }
            return FileStatus.APPROVED;
        } else {
            throw new IllegalArgumentException("empty file");
        }
    }
}
