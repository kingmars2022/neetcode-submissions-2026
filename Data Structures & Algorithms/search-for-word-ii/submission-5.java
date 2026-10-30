class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;        // 如果这里是某个单词的结尾，存下完整单词
        int childCount;     // 子节点数量，用于剪枝
    }

    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        // 1. 建 Trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char ch : w.toCharArray()) {
                int i = ch - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode();
                    cur.childCount++;
                }
                cur = cur.children[i];
            }
            cur.word = w;
        }

        // 2. 从每个格子出发 DFS
        List<String> res = new ArrayList<>();
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                dfs(board, r, c, root, res);
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> res) {
        char ch = board[r][c];
        TrieNode node = parent.children[ch - 'a'];
        if (node == null) return;              // 没有这个前缀，直接剪掉

        if (node.word != null) {               // 找到一个单词
            res.add(node.word);
            node.word = null;                  // 置空，避免重复加入
        }

        board[r][c] = '#';                     // 标记已访问
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
                    && board[nr][nc] != '#') {
                dfs(board, nr, nc, node, res);
            }
        }
        board[r][c] = ch;                      // 回溯

        // 剪枝：这个节点下面已经没有要找的单词了，就从 Trie 里删掉
        if (node.childCount == 0 && node.word == null) {
            parent.children[ch - 'a'] = null;
            parent.childCount--;
        }
    }
}