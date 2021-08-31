package springapp.microblogdynaccurate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springapp.microblogdynaccurate.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findAllByTitlePostContainingIgnoreCase(String titlePost);
    public List<Post> findAllByTagsContainingIgnoreCase(String tags);
}
