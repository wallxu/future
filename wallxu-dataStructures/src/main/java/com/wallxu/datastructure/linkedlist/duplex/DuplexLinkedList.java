package com.wallxu.datastructure.linkedlist.duplex;

import com.wallxu.datastructure.linkedlist.single.Linked;

/**
 * 双向链表
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/2 9:32
 * @since 1.0.0
 */
public class DuplexLinkedList implements Linked<DuplexHeroNode> {

    /**
     * 虚拟头节点
     */
    private DuplexHeroNode headNode = new DuplexHeroNode(0, "","");


    @Override
    public void add(int index, DuplexHeroNode node) {

    }

    @Override
    public void addByOrder(DuplexHeroNode insertNode) {

    }

    /**
     * 默认添加到双向链表的最后
     * @param node
     * @return: void
     * @author: wallxu
     * @date: 2020/7/3 16:54
     * @since 1.0.0
     */
    @Override
    public void add(DuplexHeroNode node) {
        //当前数据节点
        DuplexHeroNode curNode = headNode;

        while (curNode != null) {
            if(curNode.getNext() == null){
                //最后一个节点
                node.setPre(curNode);
                curNode.setNext(node);
                break;
            }
            curNode = curNode.getNext();
        }
    }


    @Override
    public void remove(int index) {
        //当前数据节点
        DuplexHeroNode curNode = headNode.getNext();
        if(curNode == null){
            System.out.println("当前链表没数据");
        }

        boolean flag = false;
        while(curNode != null){
            if(curNode.getNum() == index){
                flag = true;
                break;
            }
            curNode = curNode.getNext();
        }

        if(flag){
            //找到要删除的节点
            curNode.getPre().setNext(curNode.getNext());
            curNode.getNext().setPre(curNode.getPre());
        }else {
            System.out.println("当前链表没找到对应节点数据");
        }
    }

    @Override
    public DuplexHeroNode update(DuplexHeroNode updateNode) {
        //当前数据节点
        DuplexHeroNode curNode = headNode.getNext();
        if(curNode == null){
            System.out.println("当前链表没数据");
            return null;
        }

        while(curNode != null){
            if(curNode.getNum().equals(updateNode.getNum())){
                //找到要修改的节点
               curNode.setName(updateNode.getName());
               curNode.setNickName(updateNode.getNickName());
                break;
            }
            curNode = curNode.getNext();
        }
        return curNode;
    }


    @Override
    public void print() {
        //当前数据节点
        DuplexHeroNode curNode = headNode.getNext();
        if(curNode == null){
            System.out.println("当前链表没数据");
        }
        System.out.println("当前链表中的数据：---------start--------------");

        while(curNode != null){
            System.out.println(curNode);
            curNode = curNode.getNext();
        }
        System.out.println("当前链表中的数据：----------end---------------");
    }
}
