package euLorenzo.myBlogApi.My_blog_api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    @ManyToOne
    private User author;
}
