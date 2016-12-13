package io.mycat.serverproxy;

import io.mycat.backend.mysql.nio.MySQLConnection;
import io.mycat.server.ServerConnection;

/**
 * Created by jiang on 2016/12/13 0013.
 */
public class Mysession{
    public ServerConnection frontendConnection;
    public MySQLConnection read;
    public MySQLConnection write;

    public void releaseall() {
        if (read != null) {
            read.release();

        }
        if (write != null) {
            write.release();

        }
    }

    public void sendtomysql(byte[] data,boolean onlyread) {
        if (onlyread) {
            if (read != null) {
                read.write(data);
            }

        }
        else {

            if (write != null) {
                write.write(data);
                return;
            }
        }
    }

    public void sendtoclient(byte[] data) {
        frontendConnection.write(data);

    }
    public Mysession(ServerConnection frontendConnection) {
        this.frontendConnection = frontendConnection;
        Getconhander getconhander = new Getconhander(frontendConnection);
        getconhander.getSource(false);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Mysession)) {
            return false;
        }
        Mysession mysession = (Mysession) obj;
        return frontendConnection == mysession.frontendConnection;
//        return super.equals(obj);
    }

    public static void main(String[] args) {
        java.lang.System.out.println(null==args);
    }
}
