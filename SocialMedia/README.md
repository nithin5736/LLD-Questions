# Social Media Application

### Functional Requirements:

1. Upload post
2. Delete post
3. Follow user
4. Unfollow user
5. View feed (last 10 recent posts from self and followings)

### Entities:

* `User`: ID, name, followers, followings, posts
* `Post`: ID, content, timestamp, owner

### Managers:

* `SocialMediaNetworkManager`: User management, follow/unfollow
* `SocialMediaFeedManager`: Post management, feed generation
