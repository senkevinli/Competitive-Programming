class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        my_set = set()
        for num in nums:
            my_set.add(num)
        return len(my_set) != len(nums)