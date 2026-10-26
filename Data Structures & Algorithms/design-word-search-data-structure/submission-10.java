class WordDictionary {
    private Set<String> set = new HashSet<>();

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0);
    }

    private boolean dfs(char[] w, int i) {
        if (i == w.length) return set.contains(new String(w));
        if (w[i] != '.') return dfs(w, i + 1);
        for (char c = 'a'; c <= 'z'; c++) {
            w[i] = c;
            if (dfs(w, i + 1)) return true;
        }
        w[i] = '.';
        return false;
    }
}