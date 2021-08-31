package springapp.microblogdynaccurate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springapp.microblogdynaccurate.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}