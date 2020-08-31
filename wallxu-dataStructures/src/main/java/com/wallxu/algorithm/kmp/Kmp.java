package com.wallxu.algorithm.kmp;

import java.util.Arrays;

/**
 * 字符串查找，KMP算法
 *
 * @author: wallxu
 * @date: 2020/8/28 14:09
 * @since 1.0.0
 */
public class Kmp {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";

        int[] nextArr = getNextArr(str2);

        System.out.println("next数组：" + Arrays.toString(nextArr));

        int index = kmpSearch(str1, str2, nextArr);

        System.out.println("子串下标：" + index);
    }

    /**
     * 有一个字符串str1= "BBC ABCDAB ABCDABCDABDE"，和一个子串str2="ABCDABD"
     * 现在要判断str1 是否含有str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
     *
     * @param str1    主串
     * @param str2    模式串
     * @param nextArr
     * @return: int
     * @author: wallxu
     * @date: 2020/8/28 14:45
     * @since 1.0.0
     */
    private static int kmpSearch(String str1, String str2, int[] nextArr) {

        for (int i = 0, j = 0; i < str1.length(); i++) {
            //元素不相同, 后移位置
            //需要处理str1.charAt(i) ！= str2.charAt(j), 去调整j 的大小
            //KMP 算法核心点, 可以验证...
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = nextArr[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                //元素相同,比较下一个元素
                j++;
            }

            if (j == str2.length()) {
                //匹配字串
                return i - j + 1;
            }
        }

        return -1;
    }

    /**
     * 获取模式串的next数组
     * 获取到一个字符串(子串) 的部分匹配值表
     * @param str
     * @return: int[]
     * @author: wallxu
     * @date: 2020/8/28 14:25
     * @since 1.0.0
     */
    private static int[] getNextArr(String str) {
        //创建next数组
        int[] nextArr = new int[str.length()];
        //1个元素的话，返回0
        //如果字符串是长度为1 部分匹配值就是0
        nextArr[0] = 0;

        for (int i = 1, j = 0; i < str.length(); i++) {
            //元素不相同

            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现有dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp 算法的核心点
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = nextArr[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                //元素相同,比较下一个元素
                j++;
            }

            nextArr[i] = j;
        }
        return nextArr;
    }
}
