package euLorenzo.myBlogApi.My_blog_api.controller;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.repository.PostRepository;
import euLorenzo.myBlogApi.My_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }
}
