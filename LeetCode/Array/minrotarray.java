class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]){
            return nums[0];
        }
        int inflect = nums[0];
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (start <= end){
            int mid = start + (end - start)/2;
            int midVal = nums[mid];
            if (midVal >= inflect){
                // still part of ascending
                start = mid + 1;
            } else if (midVal < inflect){
                // found descending, but maybe something better?
                ans = midVal;
                end = mid - 1;
            }
        }
        return ans;
    }
}