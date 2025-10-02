package euLorenzo.myBlogApi.My_blog_api.controller;

import euLorenzo.myBlogApi.My_blog_api.Entity.User;
import euLorenzo.myBlogApi.My_blog_api.dto.AuthenticationDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.LoginResponseDTO;
import euLorenzo.myBlogApi.My_blog_api.dto.RegisterDTO;
import euLorenzo.myBlogApi.My_blog_api.repository.UserRepository;
import euLorenzo.myBlogApi.My_blog_api.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        var userId = ((User) auth.getPrincipal()).getId();

        return ResponseEntity.ok(new LoginResponseDTO(token, userId));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data) {
        if(this.userRepository.findByUsername(data.username()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(),data.email(),encryptedPassword);

        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
