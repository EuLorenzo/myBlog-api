package euLorenzo.myBlogApi.My_blog_api.repository;

import euLorenzo.myBlogApi.My_blog_api.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

}
