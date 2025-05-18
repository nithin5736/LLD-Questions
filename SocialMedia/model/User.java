package model;

import java.util.*;

public class User {
    private String userId;
    private String name;
    private Set<String> followers;
    private Set<String>followings;
    private List<Post> posts;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
        this.followers = new HashSet<>();
        this.followings = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getFollowers() {
        return this.followers;
    }

    public Set<String> getFollowings() {
        return this.followings;
    }

    public List<Post> getPosts(){
        return this.posts;
    }

    public void follow(String userId){
        followings.add(userId);
    }

    public void unfollow(String userId){
        followings.remove(userId);
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void deletePost(String postId){
        posts.removeIf(p -> p.getPostId().equals(postId));
    }
}
