package io.mycat.web.config;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
     * The Propoty.
     * 属性
     */
  public   Map<String, String> propoty;

    public FunctionModel(String name, String classname) {
        this.name = name;
        this.classname = classname;
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
}
