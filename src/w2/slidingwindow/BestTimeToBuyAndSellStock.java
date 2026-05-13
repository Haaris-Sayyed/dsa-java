package w2.slidingwindow;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int n = prices.length;
        int maxProfit = 0;

        for(int i = 0; i < n; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.maxProfit(new int[]{7,6,4,3,1}));
    }
}

/*
 *
 * Approach: This code implements a one-pass greedy algorithm to solve the "Best Time to Buy and Sell Stock" problem.
 * The core strategy is to iterate through the price list while maintaining a "running minimum" price (buyPrice).
 * For every new price encountered, the algorithm makes a binary choice:
 *  1. Update the Minimum: If the current price is lower than the lowest price seen so far,
 *     we update buyPrice because buying at this lower point offers a better potential for future profit.
 *  2. Calculate Potential Profit: If the current price is higher than buyPrice, we calculate the difference
 *     (current price minus our lowest price) and update maxProfit if this new value exceeds our previous record.
 *
 * TC : O(n)  n = length of array
 * SC: O(1)
 *
 * Input: nums = [7,1,5,3,6,4]
 * Output: 5
 *
 */
