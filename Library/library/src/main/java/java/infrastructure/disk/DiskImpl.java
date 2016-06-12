package java.infrastructure.disk;

import java.io.File;

/**
 * Created by alberto on 12/6/16.
 */
public class DiskImpl implements Disk{
    @Override
    public byte[] read(File path) throws Exception {
        throw new Exception();
    }

    @Override
    public void write(byte[] data) throws Exception {
        throw new Exception();
    }
}
