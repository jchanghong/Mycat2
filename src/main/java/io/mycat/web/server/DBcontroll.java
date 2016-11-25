package io.mycat.web.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 长宏 on 2016/11/25 0025.
 */
@RestController
public class DBcontroll {
    @GetMapping(value = "/jj")
    public String get() {
        return "jjjjjjjjjjjjj";
    }
}
