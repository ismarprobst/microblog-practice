package springapp.microblogdynaccurate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;

    @NotNull
    private String contentComment;

    @NotNull
    private String authorComment;

    @NotNull
    private Date date = new java.sql.Date(System.currentTimeMillis());

   @ManyToOne
    @JsonIgnoreProperties("comment")
    private Post post;

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

    public String getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(String authorComment) {
        this.authorComment = authorComment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
