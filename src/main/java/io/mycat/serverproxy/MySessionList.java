package io.mycat.serverproxy;

import io.mycat.backend.BackendConnection;
import io.mycat.net.FrontendConnection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiang on 2016/12/13 0013.
 */
public class MySessionList {
  public    Set<Mysession> list;
    public MySessionList() {
        list = Collections.synchronizedSet(new HashSet<>());
    }
    public Mysession findbycon(FrontendConnection frontendConnection) {
        return list.stream().filter(a -> a.frontendConnection == frontendConnection).findAny().orElse(null);
    }
    public Mysession findbycon(BackendConnection frontendConnection) {
        return list.stream().filter(a -> a.mySQLConnection == frontendConnection).findAny().orElse(null);
    }

    public void add(Mysession mysession) {
        list.add(mysession);
    }
 public void remove(Mysession mysession) {
        list.remove(mysession);
    }

    public void removecon(FrontendConnection connection) {
        Mysession mysession = findbycon(connection);
        if (mysession != null) {
            list.remove(mysession);
        }
    }
}
