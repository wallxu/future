package com.wallxu.datastructure.linkedlist.single;

import com.wallxu.datastructure.linkedlist.Linked;

import java.util.Stack;

/**
 * 单链表
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/6/29 17:55
 * @since 1.0.0
 */
public class SingleLinkedList implements Linked<HeroNode> {

    /**
     * 带头链表，头节点不能动
     */
    private HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 指定位置插入新的元素
     *
     * @param index
     * @param insertNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 19:11
     * @since 1.0.0
     */
    @Override
    public void add(int index, HeroNode insertNode) {
        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        boolean flag = false;

        while (true) {
            //看下个节点是不是要插入的位置
            if (curNode.getNum() > index) {
                //要插入的位置点
                flag = true;
                break;
            }

            if (curNode.next == null) {
                break;
            }

            //往下遍历
            curNode = curNode.next;
        }

        if (flag) {
            //原来的后节点放到插入
            insertNode.next = curNode.next;
            curNode.next = insertNode;
        } else {
            System.out.println("没有合适插入点");
        }
    }


    /**
     * 按num顺序插入新的元素
     *
     * @param insertNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 19:11
     * @since 1.0.0
     */
    @Override
    public void addByOrder(HeroNode insertNode) {
        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        boolean flag = false;
        while (true) {
            if (curNode.next == null) {
                break;
            }

            //看下个节点是不是要插入的位置
            if (curNode.next.getNum() > insertNode.getNum()) {
                //要插入的位置点
                flag = true;
                break;
            }
            //往下遍历
            curNode = curNode.next;
        }

        if (flag) {
            //原来的后节点放到插入
            insertNode.next = curNode.next;
            curNode.next = insertNode;
        } else {
            curNode.next = insertNode;
        }
    }


    /**
     * 链表尾部插入新的元素
     *
     * @param insertNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 19:10
     * @since 1.0.0
     */
    @Override
    public void addLast(HeroNode insertNode) {
        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        while (true) {
            //要找到最后一个节点
            if (curNode.next == null) {
                curNode.next = insertNode;
                return;
            }
            //往下遍历
            curNode = curNode.next;
        }
    }

    @Override
    public void remove(int index) {
        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        while (true) {

            //要找到最后一个节点
            if (curNode.next == null) {
                System.out.println("当前链表没数据");
            }

            if (curNode.getNext().getNum() == index) {
                curNode.next = curNode.next.next;
                break;
            }

            //往下遍历
            curNode = curNode.next;
        }
    }

    /**
     * 更新节点数据
     *
     * @param updateNode
     * @return: com.wallxu.datastructure.linkedlist.single.HeroNode
     * @author: wallxu
     * @date: 2020/6/30 10:45
     * @since 1.0.0
     */
    @Override
    public HeroNode update(HeroNode updateNode) {

        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        while (true) {

            if (curNode.getNum().equals(updateNode.getNum())) {
                //找到要更新的数据
                curNode.setName(updateNode.getName());
                curNode.setNickName(updateNode.getNickName());
                return curNode;
            }

            //要找到最后一个节点
            if (curNode.next == null) {
                return null;
            }
            //往下遍历
            curNode = curNode.next;
        }
    }

    @Override
    public void print() {
        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        while (true) {
            //要找到最后一个节点
            if (curNode.next == null) {
                System.out.println(curNode);
                return;
            }

            System.out.println(curNode);
            //往下遍历
            curNode = curNode.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return headNode.next == null;
    }


    /**
     * 1) 求单链表中有效节点的个数
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/6/30 13:56
     * @since 1.0.0
     */
    public int getLength() {
        //临时节点保存头节点数据
        HeroNode curNode = headNode;
        if (curNode.next == null) {
            return 0;
        }

        int count = 0;
        while (curNode.next != null) {
            //要找到最后一个节点
            count++;
            //往下遍历
            curNode = curNode.next;
        }

        System.out.println("共" + count + "个节点");
        return count;
    }

    /**
     * 2) 查找单链表中的倒数第k个结点
     *
     * @param k
     * @return: com.wallxu.datastructure.linkedlist.single.HeroNode
     * @author: wallxu
     * @date: 2020/6/30 13:56
     * @since 1.0.0
     */
    public HeroNode getLastNode(int k) {
        int length = getLength();
        if (k <= 0 || k > length) {
            System.out.println("k不符合条件");
            return null;
        }

        //正数 第 length-k 个节点
        int val = length - k;
        int count = 0;
        //第一个节点数据
        HeroNode curNode = headNode.next;
        while (curNode != null) {
            if (count == val) {
                return curNode;
            }
            count++;
            //移动到下个节点
            curNode = curNode.next;
        }
        return null;
    }

    /**
     * 3) 单链表的反转
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/6/30 13:58
     * @since 1.0.0
     */
    public HeroNode reverseLinkedList() {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        //反转节点头
        HeroNode reverseNode = new HeroNode(0, "", "");

        //后一个节点
        HeroNode nextNode = null;
        //当前节点指针
        HeroNode curNode = headNode.next;

        while (curNode != null) {
            //nextNode 指向下一个节点，把curNode断掉后边的数据
            nextNode = curNode.getNext();
            //将摘掉数据的当前节点放到reverseNode反转节点后边
            curNode.next = reverseNode.next;
            reverseNode.next = curNode;
            //curNode指针向后移动
            curNode = nextNode;
        }

        //反转节点的数据，返回原链表
        headNode.next = reverseNode.next;
        return headNode;
    }


    public HeroNode reverseLinkedList2() {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        //前一个节点
        HeroNode preNode = null;
        //后一个节点
        HeroNode nextNode = null;
        //当前节点指针
        HeroNode curNode = headNode;

        while (curNode != null) {
            //nextNode 指向下一个节点
            nextNode = curNode.getNext();
            //将当前节点next域指向前一个节点
            curNode.setNext(preNode);
            //preNode 指针向后移动
            preNode = curNode;
            //curNode指针向后移动
            curNode = nextNode;

        }
        System.out.println(preNode);
        return preNode;
    }


    /**
     * 4) 从尾到头打印单链表【百度，要求方式1：反向遍历。方式2：Stack 栈】
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/6/30 13:57
     * @since 1.0.0
     */
    public void reversePrint() {
        System.out.println("从尾到头打印单链表----");
        //临时节点保存头节点数据
        HeroNode curNode = headNode.next;
        if (curNode == null) {
            return;
        }

        Stack stack = new Stack();
        while (curNode != null) {
            HeroNode tempNode = curNode.next;
            curNode.next = null;
            //要找到最后一个节点
            stack.push(curNode);
            //往下遍历
            curNode = tempNode;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


    //合并两个有序的单链表，合并之后的链表依然有序
}
