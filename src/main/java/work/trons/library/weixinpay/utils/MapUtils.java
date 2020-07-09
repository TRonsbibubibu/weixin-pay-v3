package work.trons.library.weixinpay.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
public class MapUtils {

    public static <K, V> Map<K, V> immutable(Map<? extends K, ? extends V> map) {
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> Map<K, V> immutable(K k1, V v1) {
        return Collections.singletonMap(k1, v1);
    }

    public static <K, V> Map<K, V> immutable(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> Map<K, V> immutable(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }
}
