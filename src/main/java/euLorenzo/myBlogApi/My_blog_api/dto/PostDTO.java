package euLorenzo.myBlogApi.My_blog_api.dto;

import java.util.Optional;

public record PostDTO(Optional<Integer> id, String title, String content, Integer userId) {
}
