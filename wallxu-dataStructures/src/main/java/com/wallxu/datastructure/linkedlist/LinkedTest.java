package com.wallxu.datastructure.linkedlist;

import com.wallxu.datastructure.linkedlist.single.HeroNode;
import com.wallxu.datastructure.linkedlist.single.SingleLinkedList;

/**
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/6/29 18:53
 * @since 1.0.0
 */
public class LinkedTest {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new HeroNode(1, "宋江","及时雨"));
        singleLinkedList.add(new HeroNode(2, "卢俊义","玉麒麟"));

        singleLinkedList.add(new HeroNode(3, "吴用","智多星"));
        singleLinkedList.getLength();
//        singleLinkedList.add(2, new HeroNode(4, "公孙胜","入云龙"));
//        singleLinkedList.add(3,new HeroNode(5, "关胜","大刀"));
//        singleLinkedList.getLength();
//        singleLinkedList.add(new HeroNode(6, "林冲","豹子头"));
//        singleLinkedList.update(new HeroNode(6, "林冲6","豹子头6"));

        //获取倒数第k个节点
//        System.out.println("倒数第k个节点" + singleLinkedList.getLastNode(5));

//        singleLinkedList.reverseLinkedList();
//        singleLinkedList.remove(2);


//        singleLinkedList.add(-1, new HeroNode(1, "林冲1","豹子头1"));

//        singleLinkedList.addByOrder(new HeroNode(6, "林冲","豹子头"));
//        singleLinkedList.addByOrder(new HeroNode(1, "宋江","及时雨"));
//        singleLinkedList.addByOrder(new HeroNode(4, "公孙胜","入云龙"));
//        singleLinkedList.addByOrder(new HeroNode(3, "吴用","智多星"));
//        singleLinkedList.addByOrder(new HeroNode(5, "关胜","大刀"));
        singleLinkedList.print();
        singleLinkedList.reversePrint();
    }

}
