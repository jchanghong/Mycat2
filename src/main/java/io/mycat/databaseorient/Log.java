/*
 * Copyright (c) 2016.
 * changhong@uestc
 */

package io.mycat.databaseorient;

/**
 * Created by jiang on 2016/12/16 0016.
 */
public interface Log {
    default void info(Object info) {
        System.out.println(info);
    }
}
