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
 * 数据库群的设置
 */
@SuppressWarnings("Duplicates")
@RestController
public class DataHostCconfig {
    /**
     * Gets .
     * 得到所有的数据库群
     *
     * @return the
     */
    @GetMapping(value = "/getdatahosts")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
//        SystemConfig systemConfig = MyConfigLoader.getInstance().getSystemConfig();
//        returnMessage.setObject(systemConfig);
//        returnMessage.setError(false);
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
