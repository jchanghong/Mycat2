package io.mycat.web.web;

import io.mycat.config.loader.zkprocess.entity.schema.schema.Schema;
import io.mycat.config.model.SchemaConfig;
import io.mycat.config.model.TableConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiang on 2016/12/2 0002.
 */
@RestController
public class Testconfig {

    @PostMapping("/table")
    public SchemaConfig tableconfig(@RequestBody SchemaConfig tableConfig) {

        return tableConfig;
    }
    @GetMapping("/tableget")
    public SchemaConfig tableconfiget(  SchemaConfig tableConfig) {

        return tableConfig;
    }
}
