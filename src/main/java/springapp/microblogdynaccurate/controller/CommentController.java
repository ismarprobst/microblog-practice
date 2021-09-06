package springapp.microblogdynaccurate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springapp.microblogdynaccurate.model.Comment;
import springapp.microblogdynaccurate.repository.CommentRepository;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {
	
	@Autowired
	private CommentRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Comment>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idComment}")
    public ResponseEntity<Comment>getById(@PathVariable long idComment){
    	return repository.findById(idComment).map(resp-> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
	public ResponseEntity<Comment> post(@RequestBody Comment comment){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(comment));
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Comment> put(@RequestBody Comment comment) {
		return ResponseEntity.ok(repository.save(comment));
	}
	
	@DeleteMapping("/{idComment}")
	public void delete(@PathVariable long idComment) {
		repository.deleteById(idComment);
	}
	
}
