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
 * 分区算法功能
 */
@SuppressWarnings("Duplicates")
@RestController
public class Functionconfig {
    /**
     * Gets .
     * 得到所有的分区算法
     *
     * @return the
     */
    @GetMapping(value = "/getfunctions")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
//        SystemConfig systemConfig = MyConfigLoader.getInstance().getSystemConfig();
//        returnMessage.setObject(systemConfig);
//        returnMessage.setError(false);
        return returnMessage;
    }
    /**
     * Sets .增加或者设置分区算法的属性
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/setfunction")
    public ReturnMessage setsysconfig(@Valid @RequestBody SystemConfig d, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
//        if (result.hasErrors()) {
//            returnMessage.setError(true);
//            returnMessage.setMessage(result.toString());
//            return returnMessage;
//        }
//        MyConfigLoader.getInstance().setSystemConfig(d);
//        MyConfigLoader.getInstance().save();
//      String dd=  MyReloadConfig.reloadconfig(false);
//        if (dd == null) {
//
//            returnMessage.setError(false);
//        }
//        else {
//            returnMessage.setMessage(dd);
//            returnMessage.setError(true);
//        }
        return returnMessage;
    }

}
