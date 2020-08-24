package com.wallxu.datastructure.hash;

/**
 * 有一个公司,当有新的员工来报道时,要求将该员工的信息加入
 * (id,性别,年龄,名字,住址..),当输入该员工的id时,要求查找到该员工的  所有信息.
 *
 * 要求:
 * 不使用数据库,,速度越快越好=>哈希表(散列)
 * 添加时，保证按照id从低到高插入  [课后思考：如果id不是从  低到高插入，但要求各条链表仍是从低到高，怎么解决?]
 * 使用链表来实现哈希表, 该链表不带表头 [即: 链表的第一个结点就存放雇员信息]
 * 思路分析并画出示意图
 * 代码实现[增删改查(显示所有员工，按id查询)]
 *
 * @author: wallxu
 * @email:
 * @date: 2020/7/20 9:12
 * @since 1.0.0
 */
public class MyHashTable {





//表示一个雇员
class Emp {
    public int id;
    public String name;

    public Emp next; //next 默认为null
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

}
