public class MaxProfit {
     public Integer maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        Integer maxProfitPointer = 0;
        Integer minBuyPointer = prices[0];
        for(int i=1;i< prices.length; i++){
            Integer profit = prices[i] - minBuyPointer;
            maxProfitPointer = Math.max(maxProfitPointer, profit);
            minBuyPointer = Math.min(minBuyPointer, prices[i]);
        }
        
        return maxProfitPointer;
    }

    public static void main(String[] args) {
        int[] profitArr = {7,1,5,3,6,4};
        MaxProfit profit = new MaxProfit();
        int ans = profit.maxProfit(profitArr);
        System.out.println(5 == ans);

        int[] profitArr2 = {1,2,3,4,5};
        int ans2 = profit.maxProfit(profitArr2);
        System.out.println(4== ans2);

        int[] profitArr3 = {5,4,1,6};
        int ans3 = profit.maxProfit(profitArr3);
        System.out.println(5==ans3);

        int[] profitArr4 = {3,3,5,0,0,3,1,4};
        int ans4 = profit.maxProfit(profitArr4);
        System.out.println(4==ans4);
    }
}
