package euLorenzo.myBlogApi.My_blog_api.service;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post createPost(PostDTO post);

    Post updatedPost(Post post);

    void deletePost(Integer id);
}
