package euLorenzo.myBlogApi.My_blog_api.controller;

import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @GetMapping
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok();
    }
}
