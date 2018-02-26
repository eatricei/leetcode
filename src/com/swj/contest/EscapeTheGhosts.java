package com.swj.contest;

/**
 * 789. Escape The Ghosts
 * @author swj
 * @date 2018/2/26
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ghosts.length; i++){
            min = Math.min(min, Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]));
        }
        return min > (Math.abs(target[0]) + Math.abs(target[1]));
    }

    public static void main(String[] args) {
        System.out.println(new EscapeTheGhosts().escapeGhosts(new int[][]{{1,9},{2,-5},{3,8},{9,8},{-1,3},
                {8,-10}}, new int[]{8,-10}));
    }
}
