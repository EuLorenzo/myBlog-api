package euLorenzo.myBlogApi.My_blog_api.controller;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import euLorenzo.myBlogApi.My_blog_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/posts/{userId}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.getUserPosts(userId));
    }
}
