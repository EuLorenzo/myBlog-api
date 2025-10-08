package euLorenzo.myBlogApi.My_blog_api.service;

import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import euLorenzo.myBlogApi.My_blog_api.dto.AuthenticationDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.LoginResponseDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.PostResponseDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.RegisterDTO;

import java.util.List;

public interface UserService {
    LoginResponseDTO login(AuthenticationDTO data);

    void register(RegisterDTO data);

    User createUser(User user);

    List<PostResponseDTO> getUserPosts(String userId);

    User getUser(String username);
}
