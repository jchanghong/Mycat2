package io.mycat.web.webconfig;

import io.mycat.config.model.SystemConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by jiang on 2016/12/3 0003.
 *表规则的功能
 */
@SuppressWarnings("Duplicates")
@RestController
public class TableRulesconfig {
    /**
     * Gets .
     * 得打所有的表规则让用户选择
     *
     * @return the
     */
    @GetMapping(value = "/gettablerules")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
//        SystemConfig systemConfig = MyConfigLoader.getInstance().getSystemConfig();
//        returnMessage.setObject(systemConfig);
//        returnMessage.setError(false);
        return returnMessage;
    }
    /**
     * Sets .增加一个表规则或者设置一个表规则
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/addtablerule")
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
