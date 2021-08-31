package springapp.microblogdynaccurate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPost; // news id

    @NotNull
    private String titlePost;

    @NotNull
    private String contentPost;

    @NotNull
    private String authorPost;

    @NotNull
    private String tags;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis()); //Timestamp para data+hora e Date para data

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("post")
    private List<Comment> comment;


    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getAuthorPost() {
        return authorPost;
    }

    public void setAuthorPost(String authorPost) {
        this.authorPost = authorPost;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
