package euLorenzo.myBlogApi.My_blog_api.service;

import euLorenzo.myBlogApi.My_blog_api.Entity.User;

public interface UserService {
    User createUser(User user);
    User getUser(String username);
}
