package com.wallxu.algorithm.kmp;

/**
 * 暴力破解-字符串匹配问题
 * 用暴力方法解决的话就会有大量的回溯，每次只移动一位，若是不匹配，移动到下一位接着判断，浪费了大量的时间
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/8/6 17:32
 * @since 1.0.0
 */
public class BruteForceString {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";

        //判断str1 是否含有str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
        System.out.println("下标：" + getSecondStringIndex(str1, str2));

    }

    /**
     * 判断str1 是否含有str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
     *
     * @param str1
     * @param str2
     * @return: int
     * @author: xukf
     * @date: 2020/8/6 17:36
     * @since 1.0.0
     */
    private static int getSecondStringIndex(String str1, String str2) {
        //str1的遍历位置
        int i = 0;
        //str2的遍历位置
        int j = 0;

        // 保证匹配时，不越界
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                //当前字符相同，继续比较下一个
                i++;
                j++;
            } else {
                //字符不相同了，返回位置重新判断
                i = i - (j - 1);
                j = 0;
            }

            if (j == str2.length()) {
                //找到了完全的str2
                //返回初始下标
                return i - j;
            }
        }
        return -1;
    }
}
