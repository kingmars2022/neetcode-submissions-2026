public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[queries.length];
        Arrays.fill(res, -1);

        int i = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];
            int originalIndex = query[1];

            while (i < intervals.length && intervals[i][0] <= q) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                int length = right - left + 1;

                minHeap.offer(new int[]{length, right});

                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                res[originalIndex] = minHeap.peek()[0];
            }
        }

        return res;
    }
}