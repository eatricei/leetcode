package com.swj.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * Given a triangle,
 * find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * @author swj
 * @date 2018/3/20
 */
public class Triangle {
    /**
     * 自上而下动态规划
     * 自下而上会简单一些
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size() - 1; i ++){
            List<Integer> temp = triangle.get(i);
            List<Integer> tempAdd = triangle.get(i+1);
            for (int j = 0; j < tempAdd.size(); j ++){
                if (j == 0){
                    tempAdd.set(j, temp.get(0) + tempAdd.get(0));
                } else if (j == tempAdd.size() - 1){
                    tempAdd.set(j, temp.get(j - 1) + tempAdd.get(j));
                } else {
                    tempAdd.set(j, Math.min(temp.get(j - 1), temp.get(j)) + tempAdd.get(j));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (Integer a : triangle.get(triangle.size()-1)){
            result = Math.min(result, a);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6); list3.add(5); list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(new Triangle().minimumTotal(list));
    }
}
