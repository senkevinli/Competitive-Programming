class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int inflect = nums[0];
        boolean inFirstHalf = target >= inflect;
        while (start <= end){
            int mid = start + (end - start)/2;
            int midVal = nums[mid];
            if (midVal == target) return mid;
            if (midVal >= inflect){
                if (inFirstHalf && midVal > target) end = mid - 1;
                else start = mid + 1;
            } else {
                if (!inFirstHalf && midVal < target) start = mid + 1;
                else end = mid -1;
            }
        }
        return -1;
    }
}