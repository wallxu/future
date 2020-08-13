package com.wallxu.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 贪心算法最佳应用-集合覆盖
 * 假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。
 * 如何选择最少的广播台，让所有的地区都可以接收到信号
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/8/12 11:20
 * @since 1.0.0
 */
public class RadioStationCoverGreedy {
    public static void main(String[] args) {

        //创建广播电台,放入到Map
        HashMap<String, HashSet<String>> radioStationMap = new HashMap<String, HashSet<String>>();
        //将各个电台放入到radioStationMap
        generateRadioStationMap(radioStationMap);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        generateAllAreas(allAreas);

        //创建ArrayList, 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        //还有地区未选择
        //如果allAreas 不为0, 则表示还没有覆盖到所有的地区
        while (!allAreas.isEmpty()) {

            String maxKey = "";
            int maxSize = 0;
            //遍历radioStationMap, 取出对应key
            for (Map.Entry<String, HashSet<String>> hashSetEntry : radioStationMap.entrySet()) {
                //K1,K2等
                String key = hashSetEntry.getKey();
                //包含的地区
                HashSet tempSet = hashSetEntry.getValue();
                //tempSet包含的地区和全部地区取交集，并赋值给tempSet
                tempSet.retainAll(allAreas);
                //有交集
                //体现出贪心算法的特点,每次都选择最优的
                if (tempSet.size() > maxSize) {
                    maxKey = key;
                    maxSize = tempSet.size();
                    selects.add(key);
                }
            }

            //从全部地区中，移除已选择的地区
            allAreas.removeAll(radioStationMap.get(maxKey));
        }

        System.out.println("选择的keyList->" + selects.toString());
    }

    /**
     * allAreas 存放所有的地区
     *
     * @param allAreas
     * @return: void
     * @author: xukf
     * @date: 2020/8/12 15:38
     * @since 1.0.0
     */
    private static void generateAllAreas(HashSet<String> allAreas) {
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
    }

    /**
     * 将各个电台放入到radioStationMap
     *
     * @param radioStationMap
     * @return: void
     * @author: xukf
     * @date: 2020/8/12 15:38
     * @since 1.0.0
     */
    private static void generateRadioStationMap(HashMap<String, HashSet<String>> radioStationMap) {
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        radioStationMap.put("K1", hashSet1);
        radioStationMap.put("K2", hashSet2);
        radioStationMap.put("K3", hashSet3);
        radioStationMap.put("K4", hashSet4);
        radioStationMap.put("K5", hashSet5);
    }
}
