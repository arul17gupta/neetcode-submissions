class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;

        Set<Integer> map = new HashSet<>();

        for(int i = 0 ;i<n;i++){
            if(map.contains(nums[i])){
                return true;
            }
            else{
                map.add(nums[i]);
            }
        }
        return false;
    }
}