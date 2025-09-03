package euLorenzo.myBlogApi.My_blog_api.service;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post createPost(Post post);



}
