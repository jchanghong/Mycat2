package io.mycat.web.webconfig;

import io.mycat.web.model.ReturnMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jiang on 2016/12/3 0003.
 */
@ControllerAdvice
public class ExceptionHander {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnMessage jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ReturnMessage message = new ReturnMessage();
        message.setError(true);
        message.setMessage(e.getMessage());
        message.setObject(null);
        message.setType(req.getMethod().toLowerCase());
        return message;
    }
}
