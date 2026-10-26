class WordDictionary {
    WordDictionary[] next = new WordDictionary[26];
    boolean end;

    public void addWord(String word) {
        WordDictionary cur = this;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new WordDictionary();
            cur = cur.next[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String w, int i, WordDictionary node) {
        if (i == w.length()) return node.end;
        char c = w.charAt(i);
        if (c != '.') return node.next[c - 'a'] != null && dfs(w, i + 1, node.next[c - 'a']);
        for (WordDictionary n : node.next)
            if (n != null && dfs(w, i + 1, n)) return true;
        return false;
    }
}