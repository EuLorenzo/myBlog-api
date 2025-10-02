package euLorenzo.myBlogApi.My_blog_api.service.Impl;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import euLorenzo.myBlogApi.My_blog_api.repository.UserRepository;
import euLorenzo.myBlogApi.My_blog_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Post> getUserPosts(String userId) {
        var user = userRepository.findById(Integer.parseInt(userId));

        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }

        System.out.println(user.get().toString());

        return user.get().getPosts();
    }

    @Override
    public User getUser(String username) {

        return userRepository.getUserByUsername(username);
    }
}

