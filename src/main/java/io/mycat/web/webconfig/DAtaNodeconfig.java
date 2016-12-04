package io.mycat.web.webconfig;

import io.mycat.config.model.DataNodeConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by jiang on 2016/12/3 0003.
 * 数据库节点配置 ji ben wancheng
 */
@SuppressWarnings("Duplicates")
@RestController
public class DAtaNodeconfig {
    /**
     * Gets .
     * 得到所有的数据库节点
     * json
     *
     * @return the
     */
    @GetMapping(value = "/getdatanodes")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        Map<String, DataNodeConfig> systemConfig = MyConfigLoader.getInstance().getDataNodes();
        returnMessage.setObject(systemConfig.values().toArray());
        returnMessage.setError(false);
        return returnMessage;
    }

    /**
     * Sets .增加一个数据库节点
     *
     * @param dataNodeConfig the d
     * @return the
     */
    @PostMapping(value = "/addnode")
    public ReturnMessage setsysconfig(@Valid @RequestBody DataNodeConfig dataNodeConfig, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        MyConfigLoader.getInstance().getDataNodes().put(dataNodeConfig.getName(), dataNodeConfig);
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
     * Sets .remove一个数据库节点
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/removenode/{name}")
    public ReturnMessage setsysconfig(String name) {

        Map<String, DataNodeConfig> hostConfigMap = MyConfigLoader.getInstance().getDataNodes();
        ReturnMessage returnMessage = new ReturnMessage();
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
        } else {
            returnMessage.setMessage("数据库node不存在");
            returnMessage.setError(true);
            return returnMessage;
        }
    }
}
