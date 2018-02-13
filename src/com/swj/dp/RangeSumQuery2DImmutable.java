package com.swj.dp;

import java.util.Arrays;

/**
 * Given a 2D matrix matrix,find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * @author swj
 * @date 2018/2/10
 */
public class RangeSumQuery2DImmutable {

    private final int[][] horizontal;
    public RangeSumQuery2DImmutable(int[][] matrix){
        horizontal = matrix;
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 1; j < matrix[i].length; j ++){
                horizontal[i][j] += matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i ++){
            if (col1 == 0){
                result += horizontal[i][col2];
            }else {
                result += horizontal[i][col2] - horizontal[i][col1 - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RangeSumQuery2DImmutable test = new RangeSumQuery2DImmutable(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(test.sumRegion(1, 2, 2, 4));
    }

}
