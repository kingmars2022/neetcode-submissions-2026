class WordDictionary {
    private final Set<String> set = new HashSet<>();

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        int i = word.indexOf('.');
        if (i == -1) return set.contains(word);
        char[] arr = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            arr[i] = c;
            if (search(new String(arr))) return true;
        }
        return false;
    }
}