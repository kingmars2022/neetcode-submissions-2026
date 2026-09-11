import java.util.*;

class Twitter {

    int time = 0;
    Map<Integer, Set<Integer>> follow = new HashMap<>();
    Map<Integer, List<int[]>> tweets = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, x -> new ArrayList<>())
              .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<int[]> list = new ArrayList<>();

        if (tweets.containsKey(userId)) {
            list.addAll(tweets.get(userId));
        }

        for (int id : follow.getOrDefault(userId, new HashSet<>())) {
            if (tweets.containsKey(id)) {
                list.addAll(tweets.get(id));
            }
        }

        list.sort((a, b) -> b[0] - a[0]);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            res.add(list.get(i)[1]);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(followerId, x -> new HashSet<>())
              .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}