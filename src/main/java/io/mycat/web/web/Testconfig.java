package io.mycat.web.web;

import io.mycat.config.loader.zkprocess.entity.schema.schema.Schema;
import io.mycat.config.model.SchemaConfig;
import io.mycat.config.model.SystemConfig;
import io.mycat.config.model.TableConfig;
import io.mycat.web.model.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2016/12/2 0002.
 */
@RestController
public class Testconfig {

    @PostMapping("/table")
    public List<SchemaConfig> tableconfig(@RequestBody SchemaConfig tableConfig) {

        List list = new ArrayList();
        list.add(tableConfig);
        list.add(tableConfig);
        list.add(tableConfig);
        return list;
    }
    @GetMapping("/tableget")
    public SchemaConfig tableconfiget(  SchemaConfig tableConfig) {

        return tableConfig;
    }
    @GetMapping("/sysget")
    public ReturnMessage tableconfiget(SystemConfig tableConfig) {

        ReturnMessage d = new ReturnMessage();
        d.setMessage("heh");
        return d;
    }
}
