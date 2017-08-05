/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gaoziqiang
 */
public class MapDemo {
    public static void main(String[] args) {
        List<String> userList = new ArrayList<String>();
        userList.add("zhangsan");
        userList.add("lisi");
        userList.add("wangwu");
        
        
        //Map
        Map<String,List> roomMap = new HashMap<String,List>();
        roomMap.put("225",userList);
        roomMap.get("225");
        System.out.println("225's users" + roomMap.get("225"));
        System.out.println("---迭代userList---");
        Iterator iterator = userList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
