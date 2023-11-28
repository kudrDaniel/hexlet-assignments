package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public final class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostsByUser(@PathVariable String userId) {
        return posts.stream()
                .filter(p -> p.getUserId() == Integer.parseInt(userId))
                .toList();
    }

    @PostMapping("/users/{userId}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPostByUser(
            @PathVariable String userId,
            @RequestBody Post post
    ) {
        post.setUserId(Integer.parseInt(userId));
        posts.add(post);
        return post;
    }
}
// END
