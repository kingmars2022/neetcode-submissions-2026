class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] seen = new boolean[amount + 1];
        q.offer(amount);
        seen[amount] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            for (int size = q.size(); size > 0; size--) {
                int cur = q.poll();
                for (int c : coins) {
                    int nxt = cur - c;
                    if (nxt == 0) return steps;
                    if (nxt > 0 && !seen[nxt]) {
                        seen[nxt] = true;
                        q.offer(nxt);
                    }
                }
            }
        }
        return -1;
    }
}