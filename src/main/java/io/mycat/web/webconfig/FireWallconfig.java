package io.mycat.web.webconfig;

import io.mycat.config.model.FirewallConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiang on 2016/12/3 0003.
 * 防火墙的配置
 */
@SuppressWarnings("Duplicates")
@RestController
public class FireWallconfig {
    /**
     * Gets .
     * 得到黑名单主机名
     *
     * @return the
     */
    @GetMapping(value = "/getfireconfig")
    public ReturnMessage getsys() {
        ReturnMessage returnMessage = new ReturnMessage();
        FirewallConfig systemConfig = MyConfigLoader.getInstance().getFirewallConfig();
        returnMessage.setObject(systemConfig.getBlacklist().toArray());
        returnMessage.setError(false);
        return returnMessage;
    }

    /**
     * Sets .增加一个黑名单
     *
     * @param d      the d
     * @param result the result
     * @return the
     */
    @PostMapping(value = "/addfireblack/{hostname}")
    public ReturnMessage setsysconfig(@PathVariable String hostname) {
        ReturnMessage returnMessage = new ReturnMessage();
        FirewallConfig firewallConfig = MyConfigLoader.getInstance().getFirewallConfig();
        firewallConfig.addblackhost(hostname);
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
