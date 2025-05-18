package manager;

import model.*;
import java.util.*;
import java.util.stream.Collectors;

public class SocialMediaFeedManager {
    private SocialMediaNetworkManager socialMediaNetworkManager;

    public SocialMediaFeedManager(SocialMediaNetworkManager socialMediaNetworkManager) {
        this.socialMediaNetworkManager = socialMediaNetworkManager;
    }

    public List<Post> getFeed(String userId) {
        User user = socialMediaNetworkManager.getUser(userId);
        List<Post> feedPosts = new ArrayList<>();

        if (user == null)
            return feedPosts;

        feedPosts.addAll(user.getPosts());

        for (String follwingId : user.getFollowings()) {
            User followingUser = socialMediaNetworkManager.getUser(follwingId);
            if (followingUser != null) {
                feedPosts.addAll(followingUser.getPosts());
            }
        }

        return feedPosts.stream()
                .sorted((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .limit(10)
                .collect(Collectors.toList());
    }
}