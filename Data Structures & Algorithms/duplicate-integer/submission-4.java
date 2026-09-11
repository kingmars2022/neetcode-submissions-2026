/*
I use a HashSet to keep track of the numbers I’ve already seen. 
As I go through the array, if the current number is already in the set, 
I return true. Otherwise, I add it to the set. 
If no duplicate is found, I return false. 
This gives us O(n) time and O(n) space.
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}