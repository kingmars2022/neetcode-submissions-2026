class WordDictionary {
    private static class Node {
        Node[] ch = new Node[26];
        boolean end;
    }
    private final Node root = new Node();

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.ch[k] == null) cur.ch[k] = new Node();
            cur = cur.ch[k];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String w, int i, Node node) {
        if (i == w.length()) return node.end;
        char c = w.charAt(i);
        if (c == '.') {
            for (Node next : node.ch) {
                if (next != null && dfs(w, i + 1, next)) return true;
            }
            return false;
        }
        Node next = node.ch[c - 'a'];
        return next != null && dfs(w, i + 1, next);
    }
}