class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int mul = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
                continue;
            }
            mul *= nums[i];
        }

        if (cnt == 0) {
            for (int i = 0; i < n; i++) {
                nums[i] = mul / nums[i];
            }
        } else if (cnt == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    nums[i] = mul;
                    continue;
                }
                nums[i] = 0;
            }
        } else {
            for (int i = 0; i < n; i++) {
                nums[i] = 0;
            }
        }
        return nums;
    }
}
