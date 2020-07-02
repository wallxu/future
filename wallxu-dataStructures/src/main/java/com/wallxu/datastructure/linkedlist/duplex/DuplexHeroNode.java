package com.wallxu.datastructure.linkedlist.duplex;

/**
 * 循环节点
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/1 21:15
 * @since 1.0.0
 */
public class DuplexHeroNode {

    /**
     * 编号
     */
    private Integer num;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 下个元素
     */
    private DuplexHeroNode next;

    /**
     * 上个元素
     */
    private DuplexHeroNode pre;

    public DuplexHeroNode(Integer num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public DuplexHeroNode getNext() {
        return next;
    }

    public void setNext(DuplexHeroNode next) {
        this.next = next;
    }

    public DuplexHeroNode getPre() {
        return pre;
    }

    public void setPre(DuplexHeroNode pre) {
        this.pre = pre;
    }


    @Override
    public String toString() {
        return "CircleHeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}
