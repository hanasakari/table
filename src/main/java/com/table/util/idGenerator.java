package com.table.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanas on 2018/6/13.
 */
@Service
public class idGenerator {
    private static List<String> list = new ArrayList<String>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(produceUID(20));
        }
    }

    /**
     * 生成一个长度为bits的随机数字字串
     *
     * @param bits
     * @return
     */
    public static String produceUID(int bits) {
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
}
