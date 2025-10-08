package euLorenzo.myBlogApi.My_blog_api.repository;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findPostByUserId(Integer userId);

}
