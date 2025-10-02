package euLorenzo.myBlogApi.My_blog_api.service;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<Post> getUserPosts(String userId);

    User getUser(String username);
}
