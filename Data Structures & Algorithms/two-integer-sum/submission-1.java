/*
I use a HashMap to store each number and its index. 
For each element, I calculate the complement as target - nums[i]. 
If the complement is already in the map, I return its index and the current index. 
Otherwise, I store the current number and index in the map. 
This gives O(n) time and O(n) space.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}