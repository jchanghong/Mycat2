package io.mycat.web.config;

/**
 * Created by 长宏 on 2016/11/25 0025.
 * 这个文件用来保存配置信息到文件
 *
 */
public class MystoreConfig {
    public static void saveconfig() {
        MyConfigLoader.getInstance().save();
    }
}
