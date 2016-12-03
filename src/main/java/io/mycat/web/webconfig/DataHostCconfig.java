package io.mycat.web.webconfig;

import io.mycat.config.model.DataHostConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by jiang on 2016/12/3 0003.
 * 数据库群的设置.功能基本完成
 */
@SuppressWarnings("Duplicates")
@RestController
public class DataHostCconfig {
    /**
     * Gets .
     * 得到所有的数据库群,json数组
     *
     * @return the
     */
    @GetMapping(value = "/getdatahosts")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setError(false);
        returnMessage.setObject(MyConfigLoader.getInstance().getDataHostConfigMap().values().toArray());
        return returnMessage;
    }

    /**
     * Sets .增加一个数据库群
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/adddatahost")
    public ReturnMessage setsysconfig(@Valid @RequestBody DataHostConfig dataHostConfig, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        String name = dataHostConfig.getName();
        MyConfigLoader.getInstance().getDataHostConfigMap().put(name, dataHostConfig);
        MyConfigLoader.getInstance().save();
        String dd = MyReloadConfig.reloadconfig(false);
        if (dd == null) {

            returnMessage.setError(false);
        } else {
            returnMessage.setMessage(dd);
            returnMessage.setError(true);
        }
        return returnMessage;
    }
    /**
     * Sets .删除一个数据库群
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/removedatahost/{name}")
    public ReturnMessage removedatahoast(@PathVariable String name) {
        ReturnMessage returnMessage = new ReturnMessage();
        Map<String, DataHostConfig> hostConfigMap = MyConfigLoader.getInstance().getDataHostConfigMap();
        if (hostConfigMap.keySet().contains(name)) {
            returnMessage.setError(false);
            hostConfigMap.remove(name);
            MyConfigLoader.getInstance().save();
            String dd = MyReloadConfig.reloadconfig(false);
            if (dd == null) {

                returnMessage.setError(false);
            } else {
                returnMessage.setMessage(dd);
                returnMessage.setError(true);
            }
            return returnMessage;
        }else {
            returnMessage.setMessage("数据库不存在");
            returnMessage.setError(true);
            return returnMessage;
        }

    }

}
