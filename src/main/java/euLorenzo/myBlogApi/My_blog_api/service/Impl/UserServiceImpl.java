package euLorenzo.myBlogApi.My_blog_api.service.Impl;

import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import euLorenzo.myBlogApi.My_blog_api.dto.AuthenticationDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.LoginResponseDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.PostResponseDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.RegisterDTO;
import euLorenzo.myBlogApi.My_blog_api.exceptions.UserAlreadyExistsException;
import euLorenzo.myBlogApi.My_blog_api.repository.PostRepository;
import euLorenzo.myBlogApi.My_blog_api.repository.UserRepository;
import euLorenzo.myBlogApi.My_blog_api.security.TokenService;
import euLorenzo.myBlogApi.My_blog_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public LoginResponseDTO login(AuthenticationDTO data) {
        if(userRepository.findByUsername(data.username()) == null){
            throw new RuntimeException("Username or password incorrect");
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        var userId = ((User) auth.getPrincipal()).getId();

        return new LoginResponseDTO(token, userId);
    }

    @Override
    public void register(RegisterDTO data){
        if(this.userRepository.findByUsername(data.username()) != null){
            throw new UserAlreadyExistsException("An user with this username already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(),data.email(),encryptedPassword);

        userRepository.save(newUser);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<PostResponseDTO> getUserPosts(String userId) {
        var userPosts = postRepository.findPostByUserId(Integer.parseInt(userId));

        var postsResponseDTOs = new ArrayList<PostResponseDTO>();

        userPosts.forEach(post -> {
            var postDto = new PostResponseDTO(post.getId(), post.getTitle(), post.getContent(), post.getUser().getUsername());
            postsResponseDTOs.add(postDto);
        });

        return postsResponseDTOs;
    }

    @Override
    public User getUser(String username) {

        return userRepository.getUserByUsername(username);
    }
}

