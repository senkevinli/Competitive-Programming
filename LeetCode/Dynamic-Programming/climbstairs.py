class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [1]*(n+1)
        for i in range(1, n+1):
            if i == 1:
                continue
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]
        