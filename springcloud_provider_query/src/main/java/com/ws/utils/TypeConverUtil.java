package com.ws.utils;

import java.util.ArrayList;
import java.util.List;

public class TypeConverUtil {

    /**
     * object转List方法 入参：object对象 ， List<>泛型类型
     */
    public static <T> List<T> objToList(Object o, Class<T> c) {

        List<T> list = new ArrayList<>();
        if (o instanceof ArrayList<?>) {
            ((List<?>) o).forEach(
                    o1 -> {
                        list.add(c.cast(o1));
                    }
            );
            return list;
        } else {
            return null;
        }
    }

}
