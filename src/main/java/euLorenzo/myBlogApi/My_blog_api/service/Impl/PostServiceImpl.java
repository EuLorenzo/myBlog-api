package euLorenzo.myBlogApi.My_blog_api.service.Impl;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.repository.PostRepository;
import euLorenzo.myBlogApi.My_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
