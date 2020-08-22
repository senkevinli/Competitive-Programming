class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def getKey(item):
            return item[0]
        
        # two pointers method
        temp = []
        for i, num in enumerate(nums):
            temp.append([num, i])
        print(temp)
        temp = sorted(temp, key=getKey)
        start = 0 # smallest
        end = len(nums) - 1 # largest
        while start < end:
            tSum = temp[start][0] + temp[end][0]
            if tSum < target:
                start+=1
            elif tSum > target:
                end-=1
            else:
                return[temp[start][1], temp[end][1]]