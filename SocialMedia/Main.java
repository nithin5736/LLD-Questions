import model.*;
import manager.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SocialMediaNetworkManager socialMediaNetwork = new SocialMediaNetworkManager();
        SocialMediaFeedManager socialMediaFeed = new SocialMediaFeedManager(socialMediaNetwork);

        // Register Users
        socialMediaNetwork.regiserUser("u1", "Ravi");
        socialMediaNetwork.regiserUser("u2", "Rahul");
        socialMediaNetwork.regiserUser("u3", "Prane");

        // Upload Posts
        socialMediaNetwork.uploadPost("u1", "p1", "Ravi's post");
        socialMediaNetwork.uploadPost("u2", "p2", "Rahul's post");
        socialMediaNetwork.uploadPost("u3", "p3", "Prane's post");

        socialMediaNetwork.follow("u1", "u2");
        List<Post> feed = socialMediaFeed.getFeed("u1");

        System.out.println("-------Ravi's Feed after follow---------");
        for (Post p : feed) {
            System.out.println(p.getCreatedAt() + " | " + p.getUserId() + ": " + p.getContent());
        }

        socialMediaNetwork.unfollow("u1", "u2");
        feed = socialMediaFeed.getFeed("u1");

        System.out.println("-------Ravi's Feed after unfollow---------");
        for (Post p : feed) {
            System.out.println(p.getCreatedAt() + " | " + p.getUserId() + ": " + p.getContent());
        }
    }
}
