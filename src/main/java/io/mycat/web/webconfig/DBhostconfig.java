package io.mycat.web.webconfig;

import io.mycat.config.model.DBHostConfig;
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
     * 得到一个数据库群写主机下的的所有读主机信息
     * datahost是群组的名字
     *wdbhost是写主机的名字
     * @return the
     */
    @GetMapping(value = "/{datahost}/{wdbhost}/getrdbs")
    public ReturnMessage getsrdbs(@PathVariable String datahost,@PathVariable String wdbhost) {
        ReturnMessage returnMessage = new ReturnMessage();
        DataHostConfig config = MyConfigLoader.getInstance().getDataHosts().get(datahost);
        if (config == null) {
            returnMessage.setError(true);
            returnMessage.setMessage("群主不存在");
            return returnMessage;
        }
        int index = -1;
        DBHostConfig wdb = null;
        for (int i = 0; i < config.getWriteHosts().length; i++) {
            wdb = config.getWriteHosts()[i];
            if (wdb.getHostName().equals(wdbhost)) {
                index = i;
            }
        }
        if (index == -1) {
            returnMessage.setError(true);
            returnMessage.setMessage("群主存在，但是写主机不存在");
            return returnMessage;
        }
//        List<DBHostConfig> list = new ArrayList<>(5);
//        config.getReadHosts().values().forEach(a -> Collections.addAll(list, a));
        returnMessage.setObject(config.getReadHosts().get(index));
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
        int index = -1;
        DBHostConfig wdb = null;
        for (int i = 0; i < config.getWriteHosts().length; i++) {
            wdb = config.getWriteHosts()[i];
            if (wdb.getHostName().equals(dbHostConfig.getHostName())) {
                index = i;
            }
        }
        if (index != -1) {
            returnMessage.setError(true);
            returnMessage.setMessage("主机已经存在");
            return returnMessage;
        }
        config.addwhost(dbHostConfig);
        MyConfigLoader.getInstance().save();
        String dd = MyReloadConfig.reloadconfig(true);
        if (dd == null) {

            returnMessage.setError(false);
        } else {
            returnMessage.setMessage(dd);
            returnMessage.setError(true);
        }
        return returnMessage;
    }
    /**
     * Gets .
     * 增加一个从主机，
     * @return the
     */
    @PostMapping(value = "/{datahost}/{wdbhost}/addrdb")
    public ReturnMessage getsrdddbs(@PathVariable String datahost,@PathVariable String wdbhost,@Valid @RequestBody DBHostConfig dbHostConfig) {
        ReturnMessage returnMessage = new ReturnMessage();
        DataHostConfig config = MyConfigLoader.getInstance().getDataHosts().get(datahost);
        if (config == null) {
            returnMessage.setError(true);
            returnMessage.setMessage("群主不存在");
            return returnMessage;
        }
        int index = -1;
        DBHostConfig wdb = null;
        for (int i = 0; i < config.getWriteHosts().length; i++) {
            wdb = config.getWriteHosts()[i];
            if (wdb.getHostName().equals(wdbhost)) {
                index = i;
            }
        }
        if (index == -1) {
            returnMessage.setError(true);
            returnMessage.setMessage("群主存在，但是写主机不存在");
            return returnMessage;
        }
//        List<DBHostConfig> list = new ArrayList<>(5);
//        config.getReadHosts().values().forEach(a -> Collections.addAll(list, a));
        config.addrhost(index, dbHostConfig);
        MyConfigLoader.getInstance().save();
        String dd = MyReloadConfig.reloadconfig(true);
        if (dd == null) {
            returnMessage.setError(false);
        } else {
            returnMessage.setMessage(dd);
            returnMessage.setError(true);
        }
        return returnMessage;
    }
    /**
     * Sets .remove一个数据库写主机
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @GetMapping(value = "/removedbhost/{datahost}/{dbname}")
    public ReturnMessage setsysconfig(@PathVariable String datahost, @PathVariable String dbname) {

        Map<String, DataHostConfig> hostConfigMap = MyConfigLoader.getInstance().getDataHosts();
        ReturnMessage returnMessage = new ReturnMessage();
        if (hostConfigMap.keySet().contains(datahost)) {
            returnMessage.setError(false);
            hostConfigMap.get(datahost).removehost(dbname);
            MyConfigLoader.getInstance().save();
            String dd = MyReloadConfig.reloadconfig(true);
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
