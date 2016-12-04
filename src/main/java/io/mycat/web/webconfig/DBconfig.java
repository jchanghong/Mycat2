package io.mycat.web.webconfig;

import io.mycat.config.model.SchemaConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by jiang on 2016/12/3 0003.
 * 逻辑数据库的功能
 */
@SuppressWarnings("Duplicates")
@RestController
public class DBconfig {
    /**
     * Gets .
     * 得到所有的数据库
     *
     * @return the
     */
    @GetMapping(value = "/getdbs")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        Map<String, SchemaConfig> systemConfig = MyConfigLoader.getInstance().getSchemaConfigs();
        returnMessage.setObject(systemConfig.values().toArray());
        returnMessage.setError(false);
        return returnMessage;
    }
    /**
     * Sets .增加一个数据库
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/removedb/{dbname}")
    public ReturnMessage setsysconfig(@PathVariable String dbname) {
        ReturnMessage returnMessage = new ReturnMessage();
        MyConfigLoader.getInstance().getSchemaConfigs().remove(dbname);
        MyConfigLoader.getInstance().save();
      String dd=  MyReloadConfig.reloadconfig(false);
        if (dd == null) {
            returnMessage.setError(false);
        }
        else {
            returnMessage.setMessage(dd);
            returnMessage.setError(true);
        }
        return returnMessage;
    }

}
