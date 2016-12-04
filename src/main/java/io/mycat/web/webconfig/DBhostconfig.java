package io.mycat.web.webconfig;

import io.mycat.config.model.DBHostConfig;
import io.mycat.config.model.DataHostConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by jiang on 2016/12/3 0003.
 * 数据库主机的配置
 * awncheng
 */
@SuppressWarnings("Duplicates")
@RestController
public class DBhostconfig {
    /**
     * Gets .
     * 得到一个数据库群的所有写主机信息
     * datahost是群组的名字
     *
     * @return the
     */
    @GetMapping(value = "/{datahost}/getwdbs")
    public ReturnMessage getsys(@PathVariable String datahost) {
        ReturnMessage returnMessage = new ReturnMessage();
        DataHostConfig config = MyConfigLoader.getInstance().getDataHosts().get(datahost);
        if (config == null) {
            returnMessage.setError(true);
            returnMessage.setMessage("群主不存在");
            return returnMessage;
        }
        returnMessage.setObject(config.getWriteHosts());
        return returnMessage;
    }

    /**
     * Gets .
     * 得到一个数据库群的所有读主机信息
     * datahost是群组的名字
     *
     * @return the
     */
    @GetMapping(value = "/{datahost}/getrdbs")
    public ReturnMessage getsrdbs(@PathVariable String datahost) {
        ReturnMessage returnMessage = new ReturnMessage();
        DataHostConfig config = MyConfigLoader.getInstance().getDataHosts().get(datahost);
        if (config == null) {
            returnMessage.setError(true);
            returnMessage.setMessage("群主不存在");
            return returnMessage;
        }
        List<DBHostConfig> list = new ArrayList<>(5);
        config.getReadHosts().values().forEach(a -> Collections.addAll(list, a));
        returnMessage.setObject(list.toArray());
        return returnMessage;
    }

    /**
     * Sets .在一个数据库群下面增加一个写数据库主机
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/{datahost}/addwdb")
    public ReturnMessage setsysconfig(@PathVariable String datahost, @Valid @RequestBody DBHostConfig dbHostConfig, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        DataHostConfig config = MyConfigLoader.getInstance().getDataHosts().get(datahost);
        if (config == null) {
            returnMessage.setError(true);
            returnMessage.setMessage("主机群不存在");
            return returnMessage;
        }
        config.addwhost(dbHostConfig);
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
     * Sets .remove一个数据库
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/removedbhost/{datahost}/{dbname}")
    public ReturnMessage setsysconfig(@PathVariable String datahost, @PathVariable String dbname) {

        Map<String, DataHostConfig> hostConfigMap = MyConfigLoader.getInstance().getDataHosts();
        ReturnMessage returnMessage = new ReturnMessage();
        if (hostConfigMap.keySet().contains(datahost)) {
            returnMessage.setError(false);
            hostConfigMap.get(datahost).removehost(dbname);
            MyConfigLoader.getInstance().save();
            String dd = MyReloadConfig.reloadconfig(false);
            if (dd == null) {
                returnMessage.setError(false);
            } else {
                returnMessage.setMessage(dd);
                returnMessage.setError(true);
            }
            return returnMessage;
        } else {
            returnMessage.setMessage("数据库node不存在");
            returnMessage.setError(true);
            return returnMessage;
        }
    }
}
