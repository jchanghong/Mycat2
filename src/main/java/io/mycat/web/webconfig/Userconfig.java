package io.mycat.web.webconfig;

import io.mycat.config.model.UserConfig;
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
 * 用户有关的配置
 */
@SuppressWarnings("Duplicates")
@RestController
public class Userconfig {
    /**
     * Gets .
     * 得到所有用户配置
     *
     * @return the
     */
    @GetMapping(value = "/getuserconfigs")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        Map<String, UserConfig> systemConfig = MyConfigLoader.getInstance().getUserConfigs();
        returnMessage.setObject(systemConfig.values().toArray());
        returnMessage.setError(false);
        return returnMessage;
    }

    /**
     * Sets .增加一个用户配置
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/adduserconfig")
    public ReturnMessage setsysconfig(@Valid @RequestBody UserConfig d, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        Map<String, UserConfig> userConfigMap = MyConfigLoader.getInstance().getUserConfigs();
        userConfigMap.put(d.getName(), d);
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
     * Sets .设置一个用户配置的属性，被设置的用户必须存在
     *
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/setuserconfig")
    public ReturnMessage setusersysconfig(@Valid @RequestBody UserConfig d, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        Map<String, UserConfig> userConfigMap = MyConfigLoader.getInstance().getUserConfigs();
        if (!userConfigMap.containsKey(d.getName())) {
            returnMessage.setError(true);
            returnMessage.setMessage("用户不存在");
            return returnMessage;
        }
        userConfigMap.remove(d.getName());
        userConfigMap.put(d.getName(), d);
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

}
