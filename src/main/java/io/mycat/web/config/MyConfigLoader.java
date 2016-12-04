package io.mycat.web.config;

import io.mycat.config.loader.ConfigLoader;
import io.mycat.config.model.*;
import io.mycat.config.model.rule.*;
import io.mycat.config.model.rule.TableRuleConfig;

import java.util.*;

/**
 * Created by jiang on 2016/11/24 0024.
 * 这个文件用来读取和保存配置文件，目前是从文件里面读取。
 */
public class MyConfigLoader implements ConfigLoader {
    public static final String SCHEMAKEY = "schemaConfigMap";
    public static final String DATANODEKEY = "dataNodeConfigMap";
    public static final String DATAHOSTKEY = "dataHostConfigMap";
    public static final String SYSTEMKEY = "systemConfig";
    public static final String USERKEY = "userConfigMap";
    public static final String FIREWALLKEY = "firewallConfig";
    public static final String CLUSTERKEY = "clusterConfig";
    public static final String TABLE_RULEKEY = "TABLERULEKEY";
    public static final String RULE_KEY = "RULEKEYS";
    private Map<String, SchemaConfig> schemaConfigMap;
    private List<RuleConfig> ruleConfigs;
    private Map<String, io.mycat.config.model.rule.TableRuleConfig> tableRuleConfigMap;
    private Map<String, DataNodeConfig> dataNodeConfigMap;
    private Map<String, DataHostConfig> dataHostConfigMap;
    private SystemConfig systemConfig;
    private Map<String, UserConfig> userConfigMap;
    private FirewallConfig firewallConfig;
    private ClusterConfig clusterConfig;
    static final String DEFALUT_FILENAME = "map.mapdb";
    private static MyConfigLoader install = null;
    public static MyDiscMap3 map3;
    public static MyConfigLoader getInstance() {
        if (install == null) {
            install = new MyConfigLoader();
        }
        return install;
    }
    /***把配置保存到文件*/
  synchronized   public void save() {
        map3.put(SYSTEMKEY, getSystemConfig());
        map3.put(SCHEMAKEY, getSchemaConfigs());
        map3.put(DATANODEKEY, getDataNodes());
        map3.put(DATAHOSTKEY, getDataHosts());
        map3.put(USERKEY, getUserConfigs());
        map3.put(FIREWALLKEY, getFirewallConfig());
        map3.put(CLUSTERKEY, getClusterConfig());
      map3.put(TABLE_RULEKEY, getTableRuleConfigMap());
      map3.put(RULE_KEY, getRuleConfigs());
    }
    /***把配置从文件读出或者重新加载*/
  synchronized   public void load() {
        systemConfig = (SystemConfig) map3.get(SYSTEMKEY);
        schemaConfigMap = (Map<String, SchemaConfig>) map3.get(SCHEMAKEY);
        dataNodeConfigMap = (Map<String, DataNodeConfig>) map3.get(DATANODEKEY);
        dataHostConfigMap = (Map<String, DataHostConfig>) map3.get(DATAHOSTKEY);
        userConfigMap = (Map<String, UserConfig>) map3.get(USERKEY);
        firewallConfig = (FirewallConfig) map3.get(FIREWALLKEY);
        clusterConfig = (ClusterConfig) map3.get(CLUSTERKEY);
      tableRuleConfigMap = (Map<String, TableRuleConfig>) map3.get(TABLE_RULEKEY);
      ruleConfigs = (List<RuleConfig>) map3.get(RULE_KEY);
    }
    private MyConfigLoader() {
        if (map3 == null) {
            map3 = new MyDiscMap3(DEFALUT_FILENAME);
        }
        if (map3.size() <7) {
            save();
        }
        Initfunction.init();
        load();
    }
    @Override
    public SchemaConfig getSchemaConfig(String schema) {
        if (schemaConfigMap != null) {
            return schemaConfigMap.get(schema);
        }
        TableConfig tableConfig = new TableConfig("PERSON", "id", false, false,
                TableConfig.TYPE_GLOBAL_DEFAULT, "dn1", null,
                null, false, null,
                false, null, null, null);
        Map<String, TableConfig> map = new HashMap<>();
        map.put("PERSON", tableConfig);
        SchemaConfig schemaConfig = new SchemaConfig("db", null, map, 100, false);
//        schemaConfig = null;
        return schemaConfig;
    }

    @Override
    public Map<String, SchemaConfig> getSchemaConfigs() {
        if (schemaConfigMap != null) {
            return schemaConfigMap;
        }
        Map<String, SchemaConfig> map = new HashMap<>();
        map.put("db", getSchemaConfig("db"));
        return map;
    }

    @Override
    public Map<String, DataNodeConfig> getDataNodes() {
        if (dataNodeConfigMap != null) {
            return dataNodeConfigMap;
        }
        Map<String, DataNodeConfig> map = new HashMap<>();
        DataNodeConfig nodeConfig = new DataNodeConfig("dn1", "changhong", "localhost1");
        map.put("dn1", nodeConfig);
        return map;
    }

    @Override
    public Map<String, DataHostConfig> getDataHosts() {
        if (dataHostConfigMap != null) {
            return dataHostConfigMap;
        }
        Map<String, DataHostConfig> map = new HashMap<>();
        DBHostConfig dbHostConfig = new DBHostConfig("hostS1", "localhost", 3306, "localhost:3306", "root", "0000", "0000");
        dbHostConfig.setMinCon(10);
        dbHostConfig.setMaxCon(1000);
        DBHostConfig[] dataHostConfigs = new DBHostConfig[]{dbHostConfig};
        DataHostConfig hostConfig = new DataHostConfig("localhost1", "mysql",
                "native", dataHostConfigs, new HashMap<Integer,DBHostConfig[]>(), 0,
                100, false);
        hostConfig.setMinCon(10);
        hostConfig.setMaxCon(1000);
        hostConfig.setHearbeatSQL("select user()");
        map.put("localhost1", hostConfig);
        return map;
    }

    @Override
    public SystemConfig getSystemConfig() {
        if (systemConfig != null) {
            return systemConfig;
        }
        SystemConfig systemConfig = new SystemConfig();
        return systemConfig;
    }

    @Override
    public UserConfig getUserConfig(String user) {
        if (userConfigMap != null) {
            return userConfigMap.get(user);
        }
        UserConfig userConfig = new UserConfig();
        userConfig.setName("root");

        userConfig.setPassword("123456");
        HashSet<String> schemas = new HashSet<String>();
        schemas.add("db");
        userConfig.setSchemas(schemas);
        UserPrivilegesConfig privilegesConfig = new UserPrivilegesConfig();
        privilegesConfig.setCheck(false);
        userConfig.setPrivilegesConfig(privilegesConfig);
        return userConfig;
    }

    @Override
    public Map<String, UserConfig> getUserConfigs() {
        if (userConfigMap != null) {
            return userConfigMap;
        }
        Map<String, UserConfig> map = new HashMap<>();
        map.put("root", getUserConfig("root"));
        return map;
    }

    @Override
    public FirewallConfig getFirewallConfig() {
        if (firewallConfig != null) {
            return firewallConfig;
        }
        FirewallConfig firewallConfig = new FirewallConfig();
        return firewallConfig;
    }

    @Override
    public ClusterConfig getClusterConfig() {
        if (clusterConfig != null) {
            return clusterConfig;
        }
        ClusterConfig clusterConfig = new ClusterConfig();
        return clusterConfig;
    }


    public void setSchemaConfigMap(Map<String, SchemaConfig> schemaConfigMap) {
        this.schemaConfigMap = schemaConfigMap;
    }


    public void setDataNodeConfigMap(Map<String, DataNodeConfig> dataNodeConfigMap) {
        this.dataNodeConfigMap = dataNodeConfigMap;
    }



    public void setDataHostConfigMap(Map<String, DataHostConfig> dataHostConfigMap) {
        this.dataHostConfigMap = dataHostConfigMap;
    }

    public void setSystemConfig(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }


    public void setUserConfigMap(Map<String, UserConfig> userConfigMap) {
        this.userConfigMap = userConfigMap;
    }

    public void setFirewallConfig(FirewallConfig firewallConfig) {
        this.firewallConfig = firewallConfig;
    }

    public void setClusterConfig(ClusterConfig clusterConfig) {

        this.clusterConfig = clusterConfig;
    }
    public Map<String, TableRuleConfig> getTableRuleConfigMap() {
        if (tableRuleConfigMap == null) {
            tableRuleConfigMap = new HashMap<>();
        }
        return tableRuleConfigMap;
    }

    public void setTableRuleConfigMap(Map<String, TableRuleConfig> tableRuleConfigMap) {
        this.tableRuleConfigMap = tableRuleConfigMap;
    }

    public List<RuleConfig> getRuleConfigs() {
        if (ruleConfigs == null) {
            ruleConfigs = new ArrayList<>();
        }
        return ruleConfigs;
    }

    public void setRuleConfigs(List<RuleConfig> ruleConfigs) {
        this.ruleConfigs = ruleConfigs;
    }
}
