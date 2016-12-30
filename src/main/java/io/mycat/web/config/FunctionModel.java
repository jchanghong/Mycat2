package io.mycat.web.config;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiang on 2016/12/3 0003.
 * @author changhong
 * 一个对象代表一个函数
 */
public class FunctionModel implements Serializable{
    private static  long serialVersionUID = -6605226933829917213L;
    @NotNull
  private   String name;
    @NotNull
  private   String classname;

    /**
     * The Info.这个函数的描述，让用户更清楚
     */
    @NotNull
    public String info;
    /**
     * The Propoty.
     * 属性
     */
  public   Map<String, String> property;
    /**
     * The Propertyinfomation.
     * 这个map用来描述每个属性的意思。让用户方便选择
     */
    public   Map<String, String> propertyinfomation;

    public FunctionModel() {
        property = new HashMap<>();
        propertyinfomation = new HashMap<>();
    }

    public FunctionModel(String name, String classname) {
        this();
        this.name = name;
        this.classname = classname;
    }

    public Map<String, String> getProperty() {
        return property;
    }

    public void setProperty(Map<String, String> property) {
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, String> getPropertyinfomation() {
        return propertyinfomation;
    }

    public void setPropertyinfomation(Map<String, String> propertyinfomation) {
        this.propertyinfomation = propertyinfomation;
    }
}
