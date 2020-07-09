package work.trons.library.weixinpay.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * @author liujiawei
 * @date 2020/6/19
 */
public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public static String toJson(Object obj) {
        return mapper.writeValueAsString(obj);
    }

    @SneakyThrows
    public static <T> T toObject(String string, Class<T> clazz) {
        return mapper.readValue(string, clazz);
    }
}
