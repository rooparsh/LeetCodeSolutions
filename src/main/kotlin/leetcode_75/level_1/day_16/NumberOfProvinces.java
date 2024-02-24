package leetcode_75.level_1.day_16;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i, visited, isConnected);
            }
        }
        return ans;
    }

    public void dfs(int node, boolean[] visited, int[][] isConnected) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[node][i] == 1) {
                dfs(i, visited, isConnected);
            }
        }
    }
}
