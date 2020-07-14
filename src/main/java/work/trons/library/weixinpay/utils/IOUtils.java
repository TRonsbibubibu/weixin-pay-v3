package work.trons.library.weixinpay.utils;

import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
public class IOUtils {

    public final static int EOF = -1;

    public static byte[] toByteArray(final InputStream input) throws IOException {
        try (final ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            copy(input, output);
            return output.toByteArray();
        }
    }

    @SneakyThrows
    public static long copy(InputStream input, OutputStream output) {
        long count = 0;
        int n;
        byte[] buffer = new byte[4096];
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
}
