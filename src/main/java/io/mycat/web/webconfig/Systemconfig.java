package io.mycat.web.webconfig;

import io.mycat.config.model.SystemConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by jiang on 2016/12/3 0003.
 * 设置系统属性或者得到系统属性
 */
@SuppressWarnings("Duplicates")
@RestController
public class Systemconfig {
    /**
     * Gets .
     * 得到所有的系统属性。
     *
     * @return the
     */
    @GetMapping(value = "/getsysconfigs")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        SystemConfig systemConfig = MyConfigLoader.getInstance().getSystemConfig();
        returnMessage.setObject(systemConfig);
        returnMessage.setError(false);
        return returnMessage;
    }

    @PostMapping(value = "/setsysconfig")
    public ReturnMessage setsysconfig(@Valid @RequestBody SystemConfig d, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        MyConfigLoader.getInstance().setSystemConfig(d);
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
