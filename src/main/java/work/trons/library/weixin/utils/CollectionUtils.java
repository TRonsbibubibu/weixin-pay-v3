package work.trons.library.weixin.utils;

import java.util.*;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
public class CollectionUtils {
    public static <E> List<E> toList(Enumeration<? extends E> enumeration) {
        if (enumeration == null) {
            return Collections.emptyList();
        }

        ArrayList<E> list = new ArrayList<>(10);
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }

    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }
}
