class WordDictionary {
    private final Map<Integer, List<String>> buckets = new HashMap<>();

    public void addWord(String word) {
        buckets.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
    }

    public boolean search(String word) {
        List<String> list = buckets.get(word.length());
        if (list == null) return false;
        for (String w : list) {
            if (match(w, word)) return true;
        }
        return false;
    }

    private boolean match(String w, String p) {
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c != '.' && c != w.charAt(i)) return false;
        }
        return true;
    }
}