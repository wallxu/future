package com.wallxu.algorithm.backtracking;

import java.awt.*;
import java.util.ArrayList;

/**
 * 马踏棋盘算法-回溯-贪心
 * Point.x 表示第几列，对应column
 * Point.y 表示第几行，对应row
 * @author: wallxu
 * @date: 2020/8/20 10:52
 * @since 1.0.0
 */
public class HorseChessboard {
    /**
     * 棋盘的列数
     */
    private static int X;
    /**
     * 棋盘的行数
     */
    private static int Y;

    /**
     * 创建一个数组，标记棋盘的各个位置是否被访问过
     */
    private static boolean[] visited;

    /**
     * 使用一个属性，标记是否棋盘的所有位置都被访问
     * 如果为true,表示成功
     */
    private static boolean finished;

    public static void main(String[] args) {
        System.out.println("骑士周游算法，开始运行~~");

        //测试骑士周游算法是否正确
        X = 8;
        Y = 8;
        //马儿初始位置的行，从1 开始编号
        int row = 1;
        //马儿初始位置的列，从1 开始编号
        int column = 1;

        //创建棋盘
        int[][] chessboard = new int[X][Y];
        //初始值都是false
        visited = new boolean[X * Y];

        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");


        //输出棋盘的最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成骑士周游问题的算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前的位置的行从0 开始
     * @param column     马儿当前的位置的列从0 开始
     * @param step       是第几步,初始位置就是第1 步
     */
    private static void traversalChessboard(int[][] chessboard, int row, int column, int step) {

        //Point.x 表示第几列，对应column
        //Point.y 表示第几行，对应row
        Point curPoint = new Point(column, row);
        //计算该坐标，能找到的其他坐标的个数
        ArrayList<Point> nextPoints = getNextPoints(curPoint);

        //对nextPoints 进行排序,排序的规则就是对nextPoints 的所有的Point 对象的下一步的位置的数目，进行非递减排序
        //贪心算法，把当前节点下一步的下一步最少步骤的放前面，提前失败
        sort(nextPoints);

        //记录走到了第几步
        chessboard[row][column] = step;
        //假设当前位置走的通，设为已访问
        //row = 4, X = 8, column = 4, = 4 * 8 + 4 = 36
        visited[row * X + column] = true;

        while (!nextPoints.isEmpty()) {
            //跳到下一个可以走的位置
            Point nextPoint = nextPoints.remove(0);
            //System.out.println(nextPoint.x + ", " + nextPoint.y);
            if (!visited[nextPoint.y * X + nextPoint.x]) {
                //该节点没访问过
                traversalChessboard(chessboard, nextPoint.y, nextPoint.x, step + 1);
            }
        }

        //判断马儿是否完成了任务，使用step 和应该走的步数比较，
        //如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        //说明: step < X * Y 成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            //当前位置走不通,节点设为未访问
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 对nextPoints 进行排序,
     * 排序的规则就是对nextPoints 的所有的Point对象的下一步的位置的数目，进行非递减排序
     *
     * @param nextPoints
     * @return: void
     * @author: wallxu
     * @date: 2020/8/20 20:55
     * @since 1.0.0
     */
    private static void sort(ArrayList<Point> nextPoints) {
        nextPoints.sort((p1, p2) -> {
            //获取到p1 的下一步的所有位置个数
            ArrayList<Point> nextPoints1 = getNextPoints(p1);
            //获取到p2 的下一步的所有位置个数
            ArrayList<Point> nextPoints2 = getNextPoints(p2);

            if (nextPoints1.size() < nextPoints2.size()) {
                return -1;
            } else if (nextPoints1.size() > nextPoints2.size()) {
                return 1;
            }
            return 0;
        });
    }

    /**
     * 计算该坐标，能找到的其他坐标的个数
     *
     * @param curPoint
     * @return: java.util.ArrayList<java.awt.Point>
     * @author: wallxu
     * @date: 2020/8/20 11:13
     * @since 1.0.0
     */
    private static ArrayList<Point> getNextPoints(Point curPoint) {
        ArrayList<Point> nextPointList = new ArrayList<Point>();

        //创建一个Point
        Point p1 = new Point();

        // * * * * * * * *
        // * * 6 * 7 * * *
        // * 5 * * * 0 * *
        // * * * M * * * *
        // * 4 * * * 1 * *
        // * * 3 * 2 * * *
        // * * * * * * * *
        // * * * * * * * *
        //表示马儿可以走5 这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走6 这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走7 这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走0 这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走1 这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走2 这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走3 这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            nextPointList.add(new Point(p1));
        }

        //表示马儿可以走4 这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            nextPointList.add(new Point(p1));
        }

        return nextPointList;
    }
}
