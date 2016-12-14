package io.mycat.serverproxy;

import io.mycat.backend.mysql.nio.MySQLConnection;
import io.mycat.server.ServerConnection;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by jiang on 2016/12/13 0013.
 */
public class Mysession{
    public ServerConnection frontendConnection;
    public MySQLConnection mySQLConnection;
    public void sendtomysql_queue() {
        byte[] data = (byte[]) writes.poll();
        if (data != null && mySQLConnection != null) {
            mySQLConnection.write(data);
        }
    }
    ConcurrentLinkedQueue writes = new ConcurrentLinkedQueue();
    public void sendtomysql(byte[] data,boolean onlyread) {
        if (onlyread) {
            if (mySQLConnection != null) {
                mySQLConnection.write(data);
                return;
            }
            else {
                writes.offer(data);
                Getconhander getconhander = new Getconhander(frontendConnection);
                getconhander.getSource(true);
//                mySQLConnection.write(data);
                return;
            }
        }
        else {
            if (mySQLConnection == null) {
                writes.offer(data);
                Getconhander getconhander = new Getconhander(frontendConnection);
                getconhander.getSource(false);
                return;
            }
            boolean  onlyread1 = (boolean) mySQLConnection.getAttachment();
            if (!onlyread1) {
                mySQLConnection.write(data);
                return;
            }
            else {
                if (mySQLConnection != null) {
                    mySQLConnection.release();
                    mySQLConnection = null;
                }
                writes.offer(data);
                Getconhander getconhander = new Getconhander(frontendConnection);
                getconhander.getSource(false);

            }

        }
    }

    public void sendtoclient(byte[] data) {
        frontendConnection.write(data);

    }
    public Mysession(ServerConnection frontendConnection) {
        this.frontendConnection = frontendConnection;
//        Getconhander getconhander = new Getconhander(frontendConnection);
//        getconhander.getSource(true);
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
