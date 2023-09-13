package cz.ivosahlik.clamav;

import cz.ivosahlik.domain.FileStatus;
import org.springframework.web.multipart.MultipartFile;

public interface CheckService {

    FileStatus checkFile(MultipartFile input) throws Exception;

    FileStatus checkFile(byte[] input) throws Exception;


}
