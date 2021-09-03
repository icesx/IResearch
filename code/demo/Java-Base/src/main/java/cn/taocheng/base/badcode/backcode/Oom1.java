/**
 * Program  : Oom1<br/>
 * Author   : i<br/>
 * Create   : 2021/4/21,下午5:34<br/>
 * <p>
 * Copyright 1997-2015 by XJGZ ltd.,
 * All rights reserved.
 */
package cn.taocheng.base.badcode.backcode;

import java.util.HashMap;
import java.util.Map;


public class Oom1 {
    private static Map<String, Map<String, String>> map = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5000000; i++) {
            Map<String,String> newMap = new HashMap<>();
            map.put(String.valueOf(i), newMap);
//            Thread.sleep(1);
        }
    }
}
