package com.wallxu.datastructure.stack;

/**
 * 固定长度的数组栈
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/2 11:54
 * @since 1.0.0
 */
public class FixedLengthArrayStack implements Stack<Integer>{

    /**
     * 数组大小
     */
    private int maxSize;
    private Integer[] arrayStack;

    /**
     * 栈顶，初始化-1
     */
    private int top = -1;


    public FixedLengthArrayStack(int size) {
        this.maxSize = size;
        arrayStack = new Integer[maxSize];
    }

    @Override
    public boolean isEmpty() {
        //是否为空
        return this.top == -1;
    }

    @Override
    public int getSize() {
        //返回栈的大小
        return top + 1;
    }

    @Override
    public void push(Integer integer) {
        if(top < maxSize - 1){
            top++;
            arrayStack[top] = integer;
        }else {
            System.out.println("栈满了，放不下了");
        }
    }

    @Override
    public Integer pop() {
        if(top >= 0){
            Integer r = arrayStack[top];
            top--;
            return r;
        }else {
            System.out.println("栈里没有数据了");
            return null;
        }
    }

    @Override
    public Integer peek() {
        if(top != -1){
            return arrayStack[top];
        }else {
            System.out.println("栈顶没数据");
            return null;
        }
    }

    @Override
    public void print() {
        if(top == -1){
            return ;
        }else {
            System.out.print("栈里数据：");
            for(int i=top; i > -1; i--){
                System.out.print("arr[" + i + "]=" + arrayStack[i] + ".");
            }
            System.out.println();
        }
    }


}
