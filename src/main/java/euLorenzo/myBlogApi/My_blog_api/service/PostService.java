package euLorenzo.myBlogApi.My_blog_api.service;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.dto.PostDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.PostResponseDTO;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllPosts();

    Post createPost(PostDTO post);

    Post updatedPost(PostDTO post);

    void deletePost(Integer id);
}
