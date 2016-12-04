package io.mycat.web.webconfig;

import io.mycat.web.config.Initfunction;
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
 * 分区规则功能
 *
 */
@SuppressWarnings("Duplicates")
@RestController
public class RuleConfig {
    /**
     * Gets .
     * 得到所有的分区g规则
     *
     * @return the
     */
    @GetMapping(value = "/getrules")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setObject(MyConfigLoader.getInstance().getRuleConfigs().toArray());
        returnMessage.setError(false);
        return returnMessage;
    }

    /**
     * Sets .增加分区规则
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/addrule")
    public ReturnMessage setsysconfig(@Valid @RequestBody io.mycat.config.model.rule.RuleConfig functionModel, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        MyConfigLoader.getInstance().getRuleConfigs().add(functionModel);
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
