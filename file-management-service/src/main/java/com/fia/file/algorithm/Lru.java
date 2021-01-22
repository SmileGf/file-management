package com.fia.file.algorithm;

import java.util.HashMap;
import java.util.LinkedList;

public class Lru <K,V>{
    /**
     * 存放 所有节点的 map
     */
    private HashMap<K,V> nodeMap;

    public static void main(String[] args) {
        // 存放所有节点的链表
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("原始链表 : " + linkedList);

        Integer i = 6;
        // 判断链表中是否存在key
        if(linkedList.contains(i)){
            linkedList.remove(i);
            linkedList.addFirst(i);
            System.out.println("新增链表1 ： " +linkedList );
            return;
        }
        // 初始化长度
        int length = 5;
        if(linkedList.size() >= length){
            linkedList.removeLast();
        }
        linkedList.addFirst(i);
        System.out.println("新增链表2 ： " +linkedList );
    }
}
