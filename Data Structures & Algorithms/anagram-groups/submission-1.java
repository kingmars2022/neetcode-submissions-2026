/*
I use a HashMap to group anagrams. For each word, I sort its characters and use the sorted string 
as the key. Words with the same sorted key are anagrams, so I add them to the same list. 
Finally, I return all the groups from the map. The time complexity is O(n * k log k), 
mainly because of sorting each word.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            map
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(word);
        }

        return new ArrayList<>(map.values());
    }
}