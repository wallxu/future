package com.wallxu.datastructure.recursion;

/**
 * 迷宫走法
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/6 19:47
 * @since 1.0.0
 */
public class Migong {

    //8行，7列的数组
    private static int row = 9;
    private static int col = 8;


    public static void main(String[] args) {

        //创建一个迷宫格子
        int[][] migong = new int[row][col];

        //初始化迷宫结构
        initMigong(migong);

        //打印迷宫结构
        print(migong);

        //走迷宫
        setWay(migong, 1, 1);

        //打印迷宫结构
        print(migong);

    }


    /**
     * 0未走过，1墙走不动，2正确道路，3走不通
     * 再得到小球路径时，可以先使用(下右上左)，
     * 如果小球能到map[6][5] 位置，则说明通路找到.
     *
     * @param map 表示地图
     * @param i   i,j 表示从地图的哪个位置开始出发(1,1)
     * @param j
     * @return: void
     * @author: xukf
     * @date: 2020/7/6 20:23
     * @since 1.0.0
     */
    private static boolean setWay(int[][] map, int i, int j) {
        if (map[row - 2][col - 2] == EleStatus.can_go.status) {
            return true;
        } else {
            //不是出口，继续走
            if (map[i][j] == EleStatus.no_way.status) {
                //墙走不通
                return false;
            } else if (map[i][j] == EleStatus.no_go.status) {
                //没有走过，设能走通
                map[i][j] = 2;
                //下走的通
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //下走不通，往右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //下,右走不通，往上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //下右上走不通，往左走
                    return true;
                } else {
                    //都走不通
                    map[i][j] = EleStatus.can_not_go.status;
                    return false;
                }
            }
            return false;
        }
    }

    private enum EleStatus{
        no_go(0),
        can_go(2),
        no_way(1),
        can_not_go(3);
        int status;

        EleStatus(int status) {
            this.status = status;
        }
    }

    /**
     * 初始化迷宫结构
     *
     * @param migong
     * @return: void
     * @author: xukf
     * @date: 2020/7/6 20:23
     * @since 1.0.0
     */
    private static void initMigong(int[][] migong) {
        //两列墙
        for (int i = 0; i < row; i++) {
            migong[i][0] = 1;
            migong[i][col - 1] = 1;
        }

        //两行墙
        for (int j = 0; j < col; j++) {
            migong[0][j] = 1;
            migong[row - 1][j] = 1;
        }

        //堵两个点
        migong[3][1] = 1;
        migong[3][2] = 1;
        migong[3][3] = 1;
        migong[5][4] = 1;
    }

    /**
     * 打印
     *
     * @param arr
     * @return: void
     * @author: xukf
     * @date: 2020/7/6 20:23
     * @since 1.0.0
     */
    private static void print(int[][] arr) {
        System.out.println("迷宫结构----------start----------");
        for (int[] rows : arr) {
            for (int ele : rows) {
                System.out.print(ele + " ");
            }
            System.out.println("");
        }
        System.out.println("迷宫结构----------end----------");
    }
}
