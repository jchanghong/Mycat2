package io.mycat.web.config;


import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 长宏 on 2016/11/23 0023.
 * 磁盘map实现。方法3
 */
public class MyDiscMap3 implements Map<String, Object> {
    private static final int INITSIZE = 1024 * 1024 * 1;
    private FileChannel fileChannel;
    private int filesize = 0;
    private MappedByteBuffer buffer;//性能原因。保存
    volatile private   Map<String, Object> map;
    ExecutorService executor = Executors.newSingleThreadExecutor();
    public MyDiscMap3(String file) {
        try {
            fileChannel = new RandomAccessFile(file,"rw").getChannel();
            filesize = (int) fileChannel.size();
            int buffnumber = filesize >= INITSIZE ? filesize : INITSIZE;
            buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, buffnumber);
            int size = buffer.getInt();
            if (size == 0) {
                map = new HashMap<>();
            }
            else {
                byte[] bytes = new byte[size];
                buffer.get(bytes);
                map = (Map<String, Object>) getseriObject(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object getseriObject(byte[] bytes) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
            return inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static byte[] getEsirabytes(Object object) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int size() {
        return map.size()
                ;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        Object b = map.put(key, value);
        executor.execute(synrunnable);
        return b;
    }

    @Override
    public Object remove(Object key) {
        Object o = map.remove(key);
        executor.execute(synrunnable);
        return o;
    }

    @Override
    public void putAll( Map<? extends String, ?> m) {

        map.putAll(m);
        executor.execute(synrunnable);

    }

    @Override
    public void clear() {
        map.clear();
        executor.execute(synrunnable);

    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Object> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    private Runnable synrunnable = new Runnable() {
        @Override
        public void run() {
            try {
                byte[] bytes = getEsirabytes(map);
                if (bytes.length > filesize - 4) {
                    try {
                        buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length+8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                buffer.position(0);
                buffer.putInt(bytes.length);
                buffer.put(bytes);
            } catch (Exception e) {
                //没有必要
            }
        }

    };
    public void close() {
        executor.shutdownNow();
        byte[] bytes = getEsirabytes(map);
        if (bytes.length > filesize - 4) {
            try {
                buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length+8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        buffer.position(0);
        buffer.putInt(bytes.length);
        buffer.put(bytes);
        try {
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
