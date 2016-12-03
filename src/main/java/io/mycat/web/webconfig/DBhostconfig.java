package io.mycat.web.webconfig;

import io.mycat.config.model.SystemConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jiang on 2016/12/3 0003.
 * 数据库主机的配置
 */
@SuppressWarnings("Duplicates")
@RestController
public class DBhostconfig {
    /**
     * Gets .
     * 得到一个数据库群的所有主机信息
     *
     * @return the
     */
    @GetMapping(value = "/{datahost}/getdbs")
    public ReturnMessage getsys(@PathVariable String datahost) {
        ReturnMessage returnMessage = new ReturnMessage();
//        SystemConfig systemConfig = MyConfigLoader.getInstance().getSystemConfig();
//        returnMessage.setObject(systemConfig);
//        returnMessage.setError(false);
        return returnMessage;
    }
    /**
     * Sets .在一个数据库群下面增加一个数据库主机
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/{datahost}/adddb")
    public ReturnMessage setsysconfig(@PathVariable String datahost,@Valid @RequestBody SystemConfig d, BindingResult result) {
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
