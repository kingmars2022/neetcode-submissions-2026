/*
I would use a two-pointer approach.

First, I place one pointer at the beginning and one at the end of the string.

While the pointers have not crossed, I skip any character that is not alphanumeric. 
Then I compare the two characters after converting them to lowercase.

If they are different, I return false. Otherwise, 
I move both pointers toward the center.

If I finish the loop without finding any mismatch, I return true.

The time complexity is O(n), and the space complexity is O(1).
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}