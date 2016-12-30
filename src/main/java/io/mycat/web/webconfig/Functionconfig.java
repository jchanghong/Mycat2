package io.mycat.web.webconfig;

import io.mycat.web.config.FunctionModel;
import io.mycat.web.config.Initfunction;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        returnMessage.setObject(Initfunction.functionModels.toArray());
        returnMessage.setError(false);
        return returnMessage;
    }

    /**
     * Sets .设置分区算法
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/setfunction/{name}")
    public ReturnMessage setsysconfig(@PathVariable String name, @Valid @RequestBody FunctionModel functionModel, BindingResult result) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (result.hasErrors()) {
            returnMessage.setError(true);
            returnMessage.setMessage(result.toString());
            return returnMessage;
        }
        if (!Initfunction.functionModels.contains("name")) {
            returnMessage.setError(true);
            returnMessage.setMessage("函数名字不存在");
            return returnMessage;
        }
        Initfunction.functionModels.remove("name");
        Initfunction.functionModels.add(functionModel);
        Initfunction.save();
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
