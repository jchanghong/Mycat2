package io.mycat.databaseorient.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 长宏 on 2017/3/23 0023.
 * mysql变量。还有很多很多。。。。。
 * 启动的时候会把这些存在orientdb里面，这样就可以更改。
 *
 *  /*SHOW variables WHERE Variable_name = 'language'
 OR Variable_name = 'net_write_timeout'
 OR Variable_name = 'interactive_timeout'
 OR Variable_name = 'wait_timeout'
 OR Variable_name = 'character_set_client'
 OR Variable_name = 'character_set_connection'
 OR Variable_name = 'character_set'
 OR Variable_name = 'character_set_server'
 OR Variable_name = 'tx_isolation'
 OR Variable_name = 'transaction_isolation'
 OR Variable_name = 'character_set_results'
 OR Variable_name = 'timezone'
 OR Variable_name = 'time_zone'
 OR Variable_name = 'system_time_zone'
 OR Variable_name = 'lower_case_table_names'
 OR Variable_name = 'max_allowed_packet'
 OR Variable_name = 'net_buffer_length'
 OR Variable_name = 'sql_mode'
 OR Variable_name = 'query_cache_type'
 OR Variable_name = 'query_cache_size'
 OR Variable_name = 'license'
 OR Variable_name = 'init_connect'


 -----------------------------------------------+
 | Variable_name            | Value                                                                                                                                     |
 +--------------------------+-------------------------------------------------------------------------------------------------------------------------------------------+
 | character_set_client     | gbk                                                                                                                                       |
 | character_set_connection | gbk                                                                                                                                       |
 | character_set_results    | gbk                                                                                                                                       |
 | character_set_server     | latin1                                                                                                                                    |
 | init_connect             |                                                                                                                                           |
 | interactive_timeout      | 28800                                                                                                                                     |
 | license                  | GPL                                                                                                                                       |
 | lower_case_table_names   | 1                                                                                                                                         |
 | max_allowed_packet       | 4194304                                                                                                                                   |
 | net_buffer_length        | 16384                                                                                                                                     |
 | net_write_timeout        | 60                                                                                                                                        |
 | query_cache_size         | 1048576                                                                                                                                   |
 | query_cache_type         | OFF                                                                                                                                       |
 | sql_mode                 | ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION |
 | system_time_zone         |                                                                                                                                           |
 | time_zone                | SYSTEM                                                                                                                                    |
 | tx_isolation             | REPEATABLE-READ                                                                                                                           |
 | wait_timeout             | 28800                                                                                                                                     |


 */
public class Mconstantvariables {
    public static final Map<String, String> MAP = new HashMap<>();
    static {
        MAP.put("character_set_client", "utf8");
        MAP.put("character_set_connection", "utf8");
        MAP.put("character_set_results", "utf8");
        MAP.put("character_set_server", "utf8");
        MAP.put("init_connect", "");
        MAP.put("interactive_timeout", "28800");
        MAP.put("license", "GPL");
        MAP.put("lower_case_table_names", "1");
        MAP.put("max_allowed_packet", "4194304");
        MAP.put("net_buffer_length", "16384");
        MAP.put("net_write_timeout", "60");
        MAP.put("query_cache_size", "1048576");
        MAP.put("query_cache_type", "OFF");
        MAP.put("sql_mode", "ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION ");
        MAP.put("system_time_zone", "CST");
        MAP.put("time_zone", "SYSTEM");
        MAP.put("tx_isolation", "REPEATABLE");
        MAP.put("wait_timeout", "28800");
        MAP.put("auto_increment_increment", "1");
    }
}
