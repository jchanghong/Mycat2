package io.mycat.web.webconfig;

import io.mycat.config.model.SchemaConfig;
import io.mycat.config.model.TableConfig;
import io.mycat.web.config.MyConfigLoader;
import io.mycat.web.config.MyReloadConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 长宏 on 2016/11/25 0025.
 * 这个文件只是为了演示。
 */
@RestController
public class DBcontroll {
    @GetMapping(value = "/adddb")//浏览器/adddb传dbname
    public String get(@RequestParam String dbname)
    {
        if (dbname == null) {
            dbname = "hellodb"+(Math.random() * 100) / 3;
        }
//        先得到map，然后再更改map
        MyConfigLoader.getInstance().getSchemaConfigs().put(dbname, getSchemaConfig(dbname));
        updateuserdb(dbname);
//        最后把map保存到文件
        MyConfigLoader.getInstance().save();
//        然后重新加载配置文件
        String b = MyReloadConfig.reloadconfig(false);
//        返回null说明成功。不然有错误
        if (b==null) {
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


    /**
     * D string.
     *
     * 测试错误发生的时候
     * @return the string
     */
    @GetMapping("/testerror")
    public String d() {
        throw new NullPointerException("");
    }
}
