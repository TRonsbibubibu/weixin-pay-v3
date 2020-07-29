package work.trons.library.weixinpay.utils;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
public class StringUtils {
    public final static String EMPTY = "";

    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    public static String toQuery(Map<String, String> querys) {
        return querys
                .entrySet()
                .stream()
                .filter(e -> e.getValue() != null)
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }
}
