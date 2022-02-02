package com.example.restful.helloworld.user;

import com.example.restful.helloworld.exception.DataNotFoundException;
import com.example.restful.helloworld.exception.UserNotFountException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa")
public class UserJpaController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @GetMapping("users") //localhost:8088/jpa/users
    public List<User> retrieveAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFountException(String.format("User ID is not found : %s",id));
        }
        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {

        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveuser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveuser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFountException(String.format("User ID : %s is not Found",id));
        }

        if (user.get().getPosts().isEmpty()) {
            throw new DataNotFoundException(String.format("Post is not found :: user id = %s",id));
        }

        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFountException(String.format("User is not found ID = %s",id));
        }

        post.setUser(user.get());
        Post savePost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/post/{id}")
    public void deletePost(@PathVariable int id) {
        postRepository.deleteById(id);
    }

}
