class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: count how often each number appears
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: create one empty bucket per possible frequency (0 to n)
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Step 3: put each number into the bucket for its frequency
        for (int key : map.keySet()) {
            int f = map.get(key);
            freq[f].add(key);
        }

        // Step 4: collect numbers from the highest frequency down
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 1; i--) {
            for (int num : freq[i]) {
                res[index] = num;
                index++;
                if (index == k) return res;
            }
        }
        return res;
    }
}