package euLorenzo.myBlogApi.My_blog_api.service.Impl;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.dto.PostDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.PostResponseDTO;
import euLorenzo.myBlogApi.My_blog_api.repository.PostRepository;
import euLorenzo.myBlogApi.My_blog_api.repository.UserRepository;
import euLorenzo.myBlogApi.My_blog_api.security.TokenService;
import euLorenzo.myBlogApi.My_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<PostResponseDTO> getAllPosts() {
        var posts = postRepository.findAll();

        var postsResponseDTOs = new ArrayList<PostResponseDTO>();

        posts.forEach(post -> {
            var postDto = new PostResponseDTO(post.getId(), post.getTitle(), post.getContent(), post.getUser().getUsername());
            postsResponseDTOs.add(postDto);
        });

        return postsResponseDTOs;
    }

    @Override
    public Post createPost(PostDTO post) {
        var author = userRepository.findById(post.userId());

        if(author.isPresent()){
            var newPost = new Post(post.title(), post.content(), author.get());
            return postRepository.save(newPost);
        }

        return null;
    }

    @Override
    public Post updatedPost(PostDTO post) {
        if(post.id().isPresent()){
            var newPost =  postRepository.findById(post.id().get());

            if(newPost.isPresent()){
                newPost.get().setTitle(post.title());
                newPost.get().setContent(post.content());
            }
            
            return postRepository.save(newPost.get());
        }

        return null;
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }


}
