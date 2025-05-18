package model;

import java.time.*;

public class Post {
    private String postId;
    private String content;
    private String userId;
    private LocalDateTime createdAt;

    public Post(String postId, String content, String userId) {
        this.postId = postId;
        this.content = content;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }

    public String getPostId() {
        return this.postId;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserId() {
        return this.userId;
    }

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
}
