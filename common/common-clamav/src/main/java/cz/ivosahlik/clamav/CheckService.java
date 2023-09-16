package cz.ivosahlik.clamav;

import cz.ivosahlik.domain.FileStatus;

@FunctionalInterface
public interface CheckService {

    FileStatus checkFile(byte[] input) throws Exception;

}
