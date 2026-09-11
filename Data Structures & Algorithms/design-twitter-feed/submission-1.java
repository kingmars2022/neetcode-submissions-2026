class Twitter {

    int time = 0;

    java.util.Map<Integer, java.util.Set<Integer>> follow =
            new java.util.HashMap<>();

    java.util.Map<Integer, java.util.List<int[]>> tweets =
            new java.util.HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(
                userId,
                x -> new java.util.ArrayList<>()
        ).add(new int[]{time++, tweetId});
    }

    public java.util.List<Integer> getNewsFeed(int userId) {
        java.util.List<int[]> list =
                new java.util.ArrayList<>();

        if (tweets.containsKey(userId)) {
            list.addAll(tweets.get(userId));
        }

        for (int id : follow.getOrDefault(
                userId,
                new java.util.HashSet<>())) {

            if (tweets.containsKey(id)) {
                list.addAll(tweets.get(id));
            }
        }

        list.sort((a, b) -> b[0] - a[0]);

        java.util.List<Integer> res =
                new java.util.ArrayList<>();

        for (int i = 0;
             i < Math.min(10, list.size());
             i++) {

            res.add(list.get(i)[1]);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(
                followerId,
                x -> new java.util.HashSet<>()
        ).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}