package io.mycat.web.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2016/12/3 0003.
 * 这里初始化所有的函数。
 * 然后把初始化后的函数保存到配置文件
 */
public class Initfunction {

    public static final String KEY = "functions";

    public static void save() {
        MyConfigLoader.getInstance().map3.put(KEY, functionModels);
    }
  public static   List<FunctionModel> functionModels = new ArrayList<>();
    public static void init() {
        if (MyConfigLoader.map3 == null) {
            MyConfigLoader.map3 = new MyDiscMap3(MyConfigLoader.DEFALUT_FILENAME);
        }
        if (MyConfigLoader.map3.get(KEY) != null) {
            functionModels = (List<FunctionModel>) MyConfigLoader.getInstance().map3.get(KEY);
            return;
        }
        addfunc1();
        addfunc2();
        addfunc3();
        MyConfigLoader.map3.put(KEY, functionModels);

    }

    private static void addfunc3() {
        FunctionModel functionModel = new FunctionModel("rang-long", "io.mycat.route.function.PartitionByMod");
        functionModels.add(functionModel);
    }

    private static void addfunc2() {

    }

    private static void addfunc1() {

    }
}
