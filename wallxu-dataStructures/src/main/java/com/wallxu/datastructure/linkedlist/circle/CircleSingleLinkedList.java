package com.wallxu.datastructure.linkedlist.circle;

import com.wallxu.datastructure.linkedlist.Linked;
import com.wallxu.datastructure.linkedlist.single.HeroNode;

/**
 * 单向循环链表
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/1 21:24
 * @since 1.0.0
 */
public class CircleSingleLinkedList implements Linked<HeroNode> {

    private HeroNode firstNode = null;

    public CircleSingleLinkedList() {
    }

    /**
     * 初始化一个n个节点的单向循环链表
     *
     * @param nums
     * @return:
     * @author: xukf
     * @date: 2020/7/4 14:45
     * @since 1.0.0
     */
    public CircleSingleLinkedList(int nums) {
        if (nums < 1) {
            System.out.println("nums不符合规则");
            return;
        }

        //插入一个元素
        if (nums == 1) {
            firstNode = new HeroNode(1);
            //自己指向自己
            firstNode.setNext(firstNode);
            return;
        }

        //插入多个元素
        firstNode = new HeroNode(1);
        HeroNode curNode = firstNode;
        for (int i = 1; i < nums; i++) {
            HeroNode node = new HeroNode(i+1);
            curNode.setNext(node);
            //指向下一个元素
            curNode = curNode.getNext();
        }
        //指回头节点
        curNode.setNext(firstNode);
    }

    @Override
    public void add(int index, HeroNode node) {

    }

    @Override
    public void addByOrder(HeroNode insertNode) {

    }

    @Override
    public void addLast(HeroNode node) {
        if (isEmpty()) {
            System.out.println("单向循环链表为空，无法插入数据");
            return;
        }
        HeroNode curNode = firstNode;
        while (curNode != null) {
            if (curNode.getNext() == firstNode) {
                //找到尾部元素
                node.setNext(firstNode);
                curNode.setNext(node);
                break;
            }
            curNode = curNode.getNext();
        }
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("单向循环链表为空，无法删除数据");
            return;
        }
        HeroNode curNode = firstNode;
        while (curNode != null) {
            if (curNode.getNext().getNum() == index) {
                //找到要删除元素
                curNode.setNext(curNode.getNext());
                break;
            }
            curNode = curNode.getNext();
        }
    }

    @Override
    public HeroNode update(HeroNode updateNode) {
        if (isEmpty()) {
            System.out.println("单向循环链表为空，无法更新数据");
            return null;
        }

        HeroNode curNode = firstNode;
        while (curNode != null) {
            if (curNode.getNum().equals(updateNode.getNum())) {
                //找到要删除元素
                curNode.setName(updateNode.getName());
                curNode.setNickName(updateNode.getNickName());
                return curNode;
            }

            if(curNode.getNext() == firstNode){
                System.out.println("未找到要更新的数据");
                return null;
            }
            curNode = curNode.getNext();
        }
        return null;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("单向循环链表为空，无法打印数据");
            return;
        }

        System.out.println("单向循环链表数据：---------start---------");
        HeroNode curNode = firstNode;

        while (curNode != null) {
            System.out.println(curNode);
            curNode = curNode.getNext();

            if(curNode.getNext() == firstNode){
                System.out.println(curNode);
                break;
            }
        }
        System.out.println("单向循环链表数据：---------end---------");

    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    public HeroNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(HeroNode firstNode) {
        this.firstNode = firstNode;
    }

    /**
     * Josephu 问题为：设编号为1，2，… n 的n 个人围坐一圈，约定编号为k（1<=k<=n）的人从1 开始报数，数到
     * m 的那个人出列，它的下一位又从1 开始报数，数到m 的那个人又出列，依次类推，直到所有人出列为止，由此
     * 产生一个出队编号的序列。
     *
     * 提示
     * 用一个不带头结点的循环链表来处理Josephu 问题：先构成一个有n 个结点的单循环链表，然后由k 结点起从1 开
     * 始计数，计到m 时，对应结点从链表中删除，然后再从被删除结点的下一个结点又从1 开始计数，直到最后一个
     * 结点从链表中删除算法结束。
     * @author: wallxu
     * @date: 2020/7/4 9:11
     * @since 1.0.0
     */
    /**
     * Josephu 问题为：设编号为1，2，… n 的n 个人围坐一圈，约定编号为k（1<=k<=n）的人从1 开始报数，数到
     * m 的那个人出列，它的下一位又从1 开始报数，数到m 的那个人又出列，依次类推，直到所有人出列为止，由此
     * 产生一个出队编号的序列。
     *
     * 提示:
     * 用一个不带头结点的循环链表来处理Josephu 问题：先构成一个有n 个结点的单循环链表，然后由k 结点起从1 开
     * 始计数，计到m 时，对应结点从链表中删除，然后再从被删除结点的下一个结点又从1 开始计数，直到最后一个
     * 结点从链表中删除算法结束。
     * @param nums
     * @param startNo 表示从第几个开始数数
     * @param countNum 表示数几下
     * @return: void
     * @author: xukf
     * @date: 2020/7/4 16:33
     * @since 1.0.0
     */
    public void josephu(int nums, int startNo, int countNum){
        if(startNo < 1 || startNo > nums){
            System.out.println("k值输入有误");
            return;
        }


        System.out.println("约瑟夫数据：---------------start-----------------");

        //1、创建n个元素的单向循环链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList(nums);
        setFirstNode(circleSingleLinkedList.firstNode);

        HeroNode helper = firstNode;
        //2、事先应该指向环形链表的最后这个节点
        while (helper.getNext() != firstNode) {
            helper = helper.getNext();
        }

        //3、报数前，先让first 和helper 移动k - 1 次
        for(int j = 0; j < startNo - 1; j++) {
            firstNode = firstNode.getNext();
            helper = helper.getNext();
        }

        while (true){
            if(helper == firstNode){
                break;
            }

            //4、然后让helper和first移动m-1
            for(int j = 0; j < countNum - 1; j++) {
                firstNode = firstNode.getNext();
                helper = helper.getNext();
            }

            //5、first下一个节点就是要移除的数据
            System.out.println("移除的元素：" + firstNode);
            firstNode = firstNode.getNext();
            //当前的first节点就会被回收
            helper.setNext(firstNode);
        }

        System.out.println("单向循环链表中就一个数据，移除的元素：" + firstNode);
        System.out.println("约瑟夫数据：---------------end-----------------");
    }
}
