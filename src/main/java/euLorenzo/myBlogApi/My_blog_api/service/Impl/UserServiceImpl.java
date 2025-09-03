package euLorenzo.myBlogApi.My_blog_api.service.Impl;

import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import euLorenzo.myBlogApi.My_blog_api.repository.UserRepository;
import euLorenzo.myBlogApi.My_blog_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.getUserByUsername(username);
    }
}

