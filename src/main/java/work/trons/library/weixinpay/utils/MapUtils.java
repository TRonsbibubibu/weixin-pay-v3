package work.trons.library.weixinpay.utils;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
public class MapUtils {

    public static <K, V> Map.Entry<K, V> immutableEntry(K k, V v) {
        return new AbstractMap.SimpleImmutableEntry<>(k, v);
    }

    private static <K, V> Map<K, V> buildFromEntries(Map.Entry<K, V>... entries) {
        if (entries.length <= 0) {
            return Collections.emptyMap();
        }
        Map<K, V> map = new HashMap<>(entries.length);
        for (Map.Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> Map<K, V> immutable(K k1, V v1) {
        return buildFromEntries(immutableEntry(k1, v1));
    }

    public static <K, V> Map<K, V> immutable(K k1, V v1, K k2, V v2) {
        return buildFromEntries(
                immutableEntry(k1, v1),
                immutableEntry(k2, v2)
        );
    }

    public static <K, V> Map<K, V> immutable(K k1, V v1, K k2, V v2, K k3, V v3) {
        return buildFromEntries(
                immutableEntry(k1, v1),
                immutableEntry(k2, v2),
                immutableEntry(k3, v3)
        );
    }
}
