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
        MyConfigLoader.map3.put(KEY, functionModels);
    }
  public static   List<FunctionModel> functionModels = new ArrayList<>();
    public static void init() {
        if (MyConfigLoader.map3 == null) {
            MyConfigLoader.map3 = new MyDiscMap3(MyConfigLoader.DEFALUT_FILENAME);
        }
        if (MyConfigLoader.map3.get(KEY) != null) {
            functionModels = (List<FunctionModel>) MyConfigLoader.map3.get(KEY);
            return;
        }
        addfunc1();
        addfunc2();
        addfunc3();
        addfunc4();
        addfunc5();
        addfunc6();
        addfunc7();
        addfunc8();
        addfunc9();
        addfunc10();
        MyConfigLoader.map3.put(KEY, functionModels);

    }

    private static void addfunc1() {
        FunctionModel functionModel = new FunctionModel("murmur", "io.mycat.route.function.PartitionByMurmurHash");
        functionModel.setInfo("一致性哈希算法");
        functionModel.property.put("seed", "0");
        functionModel.propertyinfomation.put("seed", "seed的描述");
        functionModel.property.put("count", "2");
        functionModel.propertyinfomation.put("count", "seed的描述");
        functionModel.property.put("virtualBucketTimes", "160");
        functionModel.propertyinfomation.put("virtualBucketTimes", "seed的描述");
        functionModel.property.put("weightMapFile", "weightMapFile");
        functionModel.propertyinfomation.put("weightMapFile", "seed的描述");
        functionModel.property.put("bucketMapPath", "/etc/mycat/bucketMapPath");
        functionModel.propertyinfomation.put("bucketMapPath", "seed的描述");
        functionModels.add(functionModel);
    }

    private static void addfunc2() {
        FunctionModel functionModel = new FunctionModel("crc32slot", "io.mycat.route.function.PartitionByCRC32PreSlot");
        functionModel.setInfo("描述信息");
        functionModel.property.put("count", "2");
        functionModel.propertyinfomation.put("count", "2");
        functionModels.add(functionModel);
    }

    private static void addfunc3() {
        FunctionModel functionModel = new FunctionModel("hash-int", "io.mycat.route.function.PartitionByFileMap");
        functionModel.setInfo("描述信息");
        functionModel.property.put("mapFile", "partition-hash-int.txt");
        functionModel.propertyinfomation.put("mapFile", "info");
        functionModels.add(functionModel);
    }
    private static void addfunc4() {
        FunctionModel functionModel = new FunctionModel("rang-long", "io.mycat.route.function.AutoPartitionByLong");
        functionModel.setInfo("描述信息");
        functionModel.property.put("mapFile", "autopartition-long.txt");
        functionModel.propertyinfomation.put("mapFile", "info");
        functionModels.add(functionModel);
    }
    private static void addfunc5() {
        FunctionModel functionModel = new FunctionModel("mod-long", "io.mycat.route.function.PartitionByMod");
        functionModel.setInfo("描述信息");
        functionModel.property.put("count", "3");
        functionModel.propertyinfomation.put("count", "info");
        functionModels.add(functionModel);
    }
    private static void addfunc6() {
        FunctionModel functionModel = new FunctionModel("func1", "io.mycat.route.function.PartitionByLong");
        functionModel.setInfo("描述信息");
        functionModel.property.put("partitionCount", "8");
        functionModel.propertyinfomation.put("partitionCount", "info");
        functionModel.property.put("partitionLength", "128");
        functionModel.propertyinfomation.put("partitionLength", "info");
        functionModels.add(functionModel);
    }
    private static void addfunc7() {
        FunctionModel functionModel = new FunctionModel("latestMonth", "io.mycat.route.function.LatestMonthPartion");
        functionModel.setInfo("描述信息");
        functionModel.property.put("splitOneDay", "24");
        functionModel.propertyinfomation.put("splitOneDay", "info");
        functionModels.add(functionModel);
    }
    private static void addfunc8() {
        FunctionModel functionModel = new FunctionModel("partbymonth", "io.mycat.route.function.PartitionByMonth");
        functionModel.setInfo("描述信息");
        functionModel.property.put("dateFormat", "yyyy-MM-dd");
        functionModel.propertyinfomation.put("dateFormat", "info");
        functionModel.property.put("sBeginDate", "2015-01-01");
        functionModel.propertyinfomation.put("sBeginDate", "info");
        functionModels.add(functionModel);
    }
    private static void addfunc9() {
        FunctionModel functionModel = new FunctionModel("rang-mod", "io.mycat.route.function.PartitionByRangeMod");
        functionModel.setInfo("描述信息");
        functionModel.property.put("mapFile", "partition-range-mod.txt");
        functionModel.propertyinfomation.put("mapFile", "partition-range-mod.txt");
        functionModels.add(functionModel);
    }
    private static void addfunc10() {
        FunctionModel functionModel = new FunctionModel("jump-consistent-hash", "io.mycat.route.function.PartitionByJumpConsistentHash");
        functionModel.setInfo("描述信息");
        functionModel.property.put("totalBuckets", "3");
        functionModel.propertyinfomation.put("totalBuckets", "info");
        functionModels.add(functionModel);
    }
}
