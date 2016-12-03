package io.mycat.web.model;

import java.io.Serializable;

/**
 * Created by jiang on 2016/12/3 0003.
 * 返回给客服端的消息，json格式。
 * 所有的返回值都是这个格式
 */
public class ReturnMessage implements Serializable{
    /**
     * The Type.
     * get或者post
     */
    String type = "get";
    /**
     * The Error.
     * 发生错误
     */
    boolean error = false;
    /**
     * The Message.
     * 错误的消息，
     * 如果没有错，这不用管
     */
    String message="";
    /**
     * The Object.
     * 请求的具体消息，
     * 如果是post请求，
     * 那么不用管这个消息
     */
    Object object=null;

    /**
     * Instantiates a new Return message.
     */
    public ReturnMessage() {
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Is error boolean.
     *
     * @return the boolean
     */
    public boolean isError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets object.
     *
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets object.
     *
     * @param object the object
     */
    public void setObject(Object object) {
        this.object = object;
    }
}
