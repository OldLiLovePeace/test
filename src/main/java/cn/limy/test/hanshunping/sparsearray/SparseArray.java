package cn.limy.test.hanshunping.sparsearray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0：表示没有棋子，1表示黑子，2表示篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        printArray(chessArr1);

        // 将二维数组 转 稀疏数组
        // 1.先遍历二维数组，得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
             for (int j = 0; j < 11; j++){
                 if(chessArr1[i][j] != 0){
                     sum++;
                 }
             }
        }
        System.out.println("sum=" + sum);

        // 2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        // 3.给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 3.遍历二维数组，将非0的值存放在sparseArr中
        int count = 0; // count 用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 4.输出稀疏数组的形式
        System.out.println("\n得到的稀疏数组");
        for (int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        // 将稀疏数组恢复成原始数组
        // 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2.读取稀疏数组的后几行数据（从第二行开始），并复制给原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 3.输出恢复后的二维数组
        System.out.println("恢复后的二维数组~~");
        printArray(chessArr2);


    }

    // 打印棋盘的方法
    public static void printArray(int[][] array){
        for (int[] row : array){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }


    /**
     * 存储稀疏数组，相邻数据使用\t划分
     * @param classpath 文件的存放路径
     * @param sparseArr 稀疏数组对象
     */
    public static void save(String classpath, int[][] sparseArr){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(classpath);
            for (int[] row : sparseArr){
                fileWriter.write(row[0] + "\t" + row[1] + "\t" + row[2]);
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取二维稀疏数组，相邻数据使用\t划分--test
     * @param classpath 文件的存放路径
     * @return 二维的稀疏数组
     */
    public static int[][] read(String classpath){
        int[][] sparseArr = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(classpath));
            String lineStr = null;
            Integer lineCount = 0;
            while ((lineStr = bufferedReader.readLine()) != null){
                String[] tempStr = lineStr.split("\t");
                if (lineCount.equals(0)){
                    // 稀疏数组的[0,2]位置记录了非0数据个数，所以稀疏数组大小为[Integer.parseInt(tempStr[2]) + 1][3]
                    sparseArr = new int[Integer.parseInt(tempStr[2]) + 1][3];
                }
                sparseArr[lineCount][0] = Integer.parseInt(tempStr[0]);
                sparseArr[lineCount][1] = Integer.parseInt(tempStr[1]);
                sparseArr[lineCount][2] = Integer.parseInt(tempStr[2]);
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparseArr;
    }

}
