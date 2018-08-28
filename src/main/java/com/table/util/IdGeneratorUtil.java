package com.table.util;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by hanas on 2018/6/13.
 */
@Service
public class IdGeneratorUtil {
    private static List<String> list = new ArrayList<String>();

    /**
     * 生成一个长度为bits的随机数字字串
     *
     * @param bits
     * @return
     */
    public  String produceUID(int bits) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < bits; i++) {
            sb.append((int) (Math.random() * 10));
        }
        String tmp = sb.toString();
        if (list.contains(tmp)) {
            produceUID(bits);
        } else {
            list.add(tmp);

            return tmp;
        }
        return "-1";
    }

    public  String UUIDGenerator(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * @param args
     */
    public  void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(produceUID(20));
        }
    }
}
