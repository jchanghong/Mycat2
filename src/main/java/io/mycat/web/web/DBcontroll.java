package io.mycat.web.web;

import io.mycat.config.model.SchemaConfig;
import io.mycat.config.model.TableConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import io.mycat.web.config.MystoreConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 长宏 on 2016/11/25 0025.
 */
@RestController
public class DBcontroll {
    @GetMapping(value = "/adddb")
    public String get()
    {
        String dbname = "hellodb"+(Math.random() * 100) / 3;
        MyConfigLoader.getInstance().getSchemaConfigs().put(dbname, getSchemaConfig(dbname));
        updateuserdb(dbname);
        MystoreConfig.saveconfig();
        boolean b = MyReloadConfig.reload();
        if (b) {
            return "增加数据库成功！！！！";
        }
        return "增加数据库失败";
    }
    public SchemaConfig getSchemaConfig(String schema) {
        TableConfig tableConfig = new TableConfig("PERSON", "id", false, false,
                TableConfig.TYPE_GLOBAL_DEFAULT, "dn1", null, null, false, null, false, null, null, null);
        Map<String, TableConfig> map = new HashMap<>();
        map.put("PERSON", tableConfig);
        SchemaConfig schemaConfig = new SchemaConfig(schema, null, map, 100, false);
//        schemaConfig = null;
        return schemaConfig;
    }

    public void updateuserdb(String dbname) {
        Set<String> dbs = MyConfigLoader.getInstance().getUserConfig("root").getSchemas();
        dbs.add(dbname);
        MyConfigLoader.getInstance().getUserConfigs().get("root").setSchemas(dbs);
    }
}
