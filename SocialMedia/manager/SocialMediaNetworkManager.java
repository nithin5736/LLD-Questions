package manager;

import model.*;
import java.util.*;

public class SocialMediaNetworkManager {
    private Map<String, User> userMap;
    private Map<String, Post> postMap;

    public SocialMediaNetworkManager() {
        this.userMap = new HashMap<>();
        this.postMap = new HashMap<>();
    }

    public void regiserUser(String userId, String name) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId, name);
            userMap.put(userId, user);
            System.out.println("User " + name + " registered.");
        }
    }

    public void uploadPost(String userId, String postId, String content) {
        User user = userMap.get(userId);
        if (user != null) {
            Post post = new Post(postId, content, userId);
            postMap.put(postId, post);
            user.addPost(post);
            System.out.println("Post uploaded by " + user.getName());
        }
    }

    public void deletePost(String userId, String postId) {
        User user = userMap.get(userId);
        if (user != null) {
            user.deletePost(postId);
            postMap.remove(postId);
            System.out.println("Post removed by " + user.getName());
        }
    }

    public void follow(String followerId, String followeeId) {
        User follower = userMap.get(followerId);
        if (follower != null) {
            follower.follow(followeeId);
            System.out.println(follower.getName() + " followed " + userMap.get(followeeId).getName());
        }
    }

    public void unfollow(String followerId, String followeeId) {
        User follower = userMap.get(followerId);
        if (follower != null) {
            follower.unfollow(followeeId);
            System.out.println(follower.getName() + " unfollowed " + userMap.get(followeeId).getName());
        }
    }

    public User getUser(String userId){
        return userMap.get(userId);
    }
}
