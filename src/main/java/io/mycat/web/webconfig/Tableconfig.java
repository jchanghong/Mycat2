package io.mycat.web.webconfig;

import io.mycat.config.model.SystemConfig;
import io.mycat.config.model.TableConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jiang on 2016/12/3 0003.
 * 表有关的配置功能
 */
@SuppressWarnings("Duplicates")
@RestController
public class Tableconfig {
    /**
     * Gets .
     * 得到一个数据库中所有的表，不是所有的表。
     *
     * @return the
     */
    @GetMapping(value = "/gettables")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setError(false);
        return returnMessage;
    }
    /**
     * Sets .增加一个表。
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/{dbname}/addtable")
    public ReturnMessage setsysconfig(@PathVariable String dbname, @Valid @RequestBody TableConfig d, BindingResult result) {
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
