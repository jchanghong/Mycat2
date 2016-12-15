package io.mycat.test;

import io.mycat.config.model.SystemConfig;
import org.modelmapper.ModelMapper;

/**
 * Created by jiang on 2016/12/15 0015.
 */
public class mapper {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        SystemConfig systemConfig = null;
        mysystem mysystem = new mysystem();
        systemConfig = modelMapper.map(mysystem, SystemConfig.class);
        System.out.println(systemConfig.getMaxResultSet());

    }
    static class mysystem
    {
        private int maxResultSet = 512 ;

        public int getMaxResultSet() {
            return maxResultSet;
        }

        public void setMaxResultSet(int maxResultSet) {
            this.maxResultSet = maxResultSet;
        }
    }
}
