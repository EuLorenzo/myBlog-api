package euLorenzo.myBlogApi.My_blog_api.controller;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.dto.PostDTO;
import euLorenzo.myBlogApi.My_blog_api.repository.PostRepository;
import euLorenzo.myBlogApi.My_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.updatedPost(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@RequestParam Integer postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
