package io.mycat.web.webconfig;

import io.mycat.web.model.ReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jiang on 2016/12/3 0003.
 */
@ControllerAdvice
public class ExceptionHander {
    Logger logger = LoggerFactory.getLogger(ExceptionHander.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnMessage jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ReturnMessage message = new ReturnMessage();
        message.setError(true);
        message.setMessage(e.getMessage());
        message.setObject(null);
        message.setType(req.getMethod().toLowerCase());
        logger.error(e.getMessage());
        e.printStackTrace();
        return message;
    }
}
