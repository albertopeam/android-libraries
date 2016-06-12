package java.infrastructure.disk;

import java.io.File;

/**
 * Created by alberto on 12/6/16.
 */
public interface Disk {
    byte[]read(File path) throws Exception;
    void write(byte[]data) throws Exception;
}
