package com.wallxu.datastructure.linkedlist;

import com.wallxu.datastructure.linkedlist.circle.CircleSingleLinkedList;
import com.wallxu.datastructure.linkedlist.duplex.DuplexHeroNode;
import com.wallxu.datastructure.linkedlist.duplex.DuplexLinkedList;
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
        //单向链表测试
//      singleLinkedListTest();
        //双向链表测试
//        duplexLinkedListTest();
        //单向循环链表测试
        circleSingleLinkedListTest();
    }

    /**
     * 单向循环链表测试
     * @return: void
     * @author: xukf
     * @date: 2020/7/4 15:15
     * @since 1.0.0
     */
    private static void circleSingleLinkedListTest() {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
//        circleSingleLinkedList.addLast(new HeroNode(5));
//        circleSingleLinkedList.print();
//        circleSingleLinkedList.update(new HeroNode(5, "55", "444"));
        circleSingleLinkedList.print();

        circleSingleLinkedList.josephu(5, 2,2);

    }

    /**
     * 双向链表测试
     * @return: void
     * @author: wallxu
     * @date: 2020/7/3 17:11
     * @since 1.0.0
     */
    private static void duplexLinkedListTest() {
        DuplexHeroNode duplexHeroNode1 = new DuplexHeroNode(1, "宋江", "及时雨");
        DuplexHeroNode duplexHeroNode2 = new DuplexHeroNode(2, "卢俊义", "玉麒麟");
        DuplexHeroNode duplexHeroNode3 = new DuplexHeroNode(3, "吴用","智多星");
        DuplexHeroNode duplexHeroNode4 = new DuplexHeroNode(4, "公孙胜","入云龙");
        DuplexHeroNode duplexHeroNode5 = new DuplexHeroNode(5, "关胜","大刀");
        DuplexLinkedList duplexLinkedList = new DuplexLinkedList();

        System.out.println("isEmpty: " + duplexLinkedList.isEmpty());
        duplexLinkedList.addLast(duplexHeroNode1);
        duplexLinkedList.addLast(duplexHeroNode2);
        System.out.println("isEmpty: " + duplexLinkedList.isEmpty());
        duplexLinkedList.addLast(duplexHeroNode3);
        duplexLinkedList.addLast(duplexHeroNode4);
        duplexLinkedList.addLast(duplexHeroNode5);
        System.out.println("isEmpty: " + duplexLinkedList.isEmpty());

        duplexLinkedList.print();

        DuplexHeroNode updateHeroNode = new DuplexHeroNode(3, "吴用3","智多星3");
        duplexLinkedList.update(updateHeroNode);
        duplexLinkedList.print();

        duplexLinkedList.remove(40);
        duplexLinkedList.print();
    }

    /**
     * 单向链表测试
     * @return: void
     * @author: wallxu
     * @date: 2020/7/3 17:11
     * @since 1.0.0
     */
    private static void singleLinkedListTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(new HeroNode(1, "宋江","及时雨"));
        singleLinkedList.addLast(new HeroNode(2, "卢俊义","玉麒麟"));

        singleLinkedList.addLast(new HeroNode(3, "吴用","智多星"));
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
        //反向打印，原链表顺序不变
        singleLinkedList.reversePrint();
    }

}
