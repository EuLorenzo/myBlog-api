package euLorenzo.myBlogApi.My_blog_api.service.Impl;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.dto.PostDTO;
import euLorenzo.myBlogApi.My_blog_api.repository.PostRepository;
import euLorenzo.myBlogApi.My_blog_api.repository.UserRepository;
import euLorenzo.myBlogApi.My_blog_api.security.TokenService;
import euLorenzo.myBlogApi.My_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(PostDTO post) {
        var author = userRepository.findById(Integer.parseInt(post.userId()));

        return postRepository.save(new Post(null, post.title(), post.content(), author.get()));
    }

    @Override
    public Post updatedPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id); ;
    }


}
