package interview_150.array;

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class BestTimeToBuySellStocks {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pIst = 0; // profit if sold today

        for (int price : prices) {
            if (price < lsf) {
                lsf = price;
            }

            pIst = price - lsf;
            if (op < pIst) {
                op = pIst;
            }

        }
        return op;
    }
}
