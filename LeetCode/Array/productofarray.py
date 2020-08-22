class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        right = [1]*len(nums)
        left = [1]*len(nums)
        
        running_product = 1
        for i in range(len(nums)):
            if i == 0:
                continue
            running_product*= nums[i-1]
            left[i] = running_product
    
        running_product = 1
        for i in range(len(nums) - 1, -1, -1):
            if i == len(nums) - 1:
                continue
            running_product*= nums[i+1]
            right[i] = running_product
        
        ret = []
        for i in range(len(nums)):
            ret.append(right[i]*left[i])
        return ret
            