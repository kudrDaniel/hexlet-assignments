package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var maxPageNum = posts.size() % 5 == 0
                ? posts.size() / 5
                : posts.size() / 5 + 1;
        var pageNum = ctx.queryParamAsClass("page", Integer.class)
                .check(value -> value > 0 && value <= maxPageNum, "Page index out of bounds")
                .getOrDefault(1);
        posts = posts.subList((pageNum - 1) * 5, pageNum * 5);
        var page = new PostsPage(posts, pageNum, maxPageNum);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END
}
