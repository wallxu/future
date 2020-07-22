package com.wallxu.datastructure.linkedlist.single;

/**
 * TODO
 *
 * @author: wallxu
 * @email:
 * @date: 2020/6/29 18:04
 * @since 1.0.0
 */
public class HeroNode {

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
    HeroNode next;

    public HeroNode(Integer num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode(Integer num) {
        this.num = num;
        this.name = String.valueOf(num);
        this.nickName = String.valueOf(num);
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
