package springapp.microblogdynaccurate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springapp.microblogdynaccurate.model.Post;
import springapp.microblogdynaccurate.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(repository.findAll()); //list all posts
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Post>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(repository.findAllByTitlePostContainingIgnoreCase(title));
    }

    @GetMapping("/by-tag/{tag}")
    public ResponseEntity<List<Post>> getByTag(@PathVariable String tag) {
        return ResponseEntity.ok(repository.findAllByTagsContainingIgnoreCase(tag));
    }


    @PostMapping
    public ResponseEntity<Post> post (@RequestBody Post post){ // Create a post
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(post));
    }

    @PutMapping("/edit")
    public ResponseEntity<Post> put (@RequestBody Post post) { // Update a post
        return ResponseEntity.ok(repository.save(post));
    }

    @DeleteMapping("/{idPost}")
    public void delete(@PathVariable long idPost) {
        repository.deleteById(idPost);
    }


}
