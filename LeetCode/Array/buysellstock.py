class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # dp solution, bad solution
        if len(prices) == 0:
            return 0
        dp = [0] * (len(prices) + 1)
        for i in range(len(prices) - 1, -1, -1):
            if prices[i] > dp[i + 1]:
                dp[i] = prices[i]
            else:
                dp[i] = dp[i+1]
        print(dp)
        
        maxDiff = 0
        for i, num in enumerate(prices):
            maxDiff = max(maxDiff, dp[i] - num)

        # better solution
        # if len(prices) == 0:
        #     return 0
        # maxi = 0
        # mini = sys.maxsize
        # for price in prices:
        #     if price < mini:
        #         mini = price
        #     else:
        #         maxi = max(maxi, price - mini)
        # return maxi
            