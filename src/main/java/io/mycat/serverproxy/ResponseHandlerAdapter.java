package io.mycat.serverproxy;

import io.mycat.backend.BackendConnection;
import io.mycat.backend.mysql.nio.handler.ResponseHandler;

import java.util.List;

/**
 * Created by jiang on 2016/12/13 0013.
 */
public abstract class  ResponseHandlerAdapter implements ResponseHandler {
    /**
     * 无法获取连接
     *
     * @param e
     * @param conn
     */
    @Override
    public void connectionError(Throwable e, BackendConnection conn) {

    }

    /**
     * 已获得有效连接的响应处理
     *
     * @param conn
     */
    @Override
    public void connectionAcquired(BackendConnection conn) {

    }

    /**
     * 收到错误数据包的响应处理
     *
     * @param err
     * @param conn
     */
    @Override
    public void errorResponse(byte[] err, BackendConnection conn) {

    }

    /**
     * 收到OK数据包的响应处理
     *
     * @param ok
     * @param conn
     */
    @Override
    public void okResponse(byte[] ok, BackendConnection conn) {

    }

    /**
     * 收到字段数据包结束的响应处理
     *
     * @param header
     * @param fields
     * @param eof
     * @param conn
     */
    @Override
    public void fieldEofResponse(byte[] header, List<byte[]> fields, byte[] eof, BackendConnection conn) {

    }

    /**
     * 收到行数据包的响应处理
     *
     * @param row
     * @param conn
     */
    @Override
    public void rowResponse(byte[] row, BackendConnection conn) {

    }

    /**
     * 收到行数据包结束的响应处理
     *
     * @param eof
     * @param conn
     */
    @Override
    public void rowEofResponse(byte[] eof, BackendConnection conn) {

    }

    /**
     * 写队列为空，可以写数据了
     */
    @Override
    public void writeQueueAvailable() {

    }

    /**
     * on connetion close event
     *
     * @param conn
     * @param reason
     */
    @Override
    public void connectionClose(BackendConnection conn, String reason) {

    }
}
