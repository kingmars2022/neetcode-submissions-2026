class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // 最大堆，放较小的一半
    private PriorityQueue<Integer> large = new PriorityQueue<>();                           // 最小堆，放较大的一半

    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());          // small 的最大值挪到 large
        if (large.size() > small.size()) {  // 保证 small 的元素个数 >= large
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) return small.peek();
        return (small.peek() + large.peek()) / 2.0;
    }
}