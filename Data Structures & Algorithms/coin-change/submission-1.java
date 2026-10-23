from collections import deque
def coinChange(self, coins, amount):
    if amount == 0: return 0
    q, seen, steps = deque([amount]), {amount}, 0
    while q:
        steps += 1
        for _ in range(len(q)):
            cur = q.popleft()
            for c in coins:
                nxt = cur - c
                if nxt == 0: return steps
                if nxt > 0 and nxt not in seen:
                    seen.add(nxt)
                    q.append(nxt)
    return -1