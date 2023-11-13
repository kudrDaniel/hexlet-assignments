package exercise.controller;

import java.util.Collections;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var password = encrypt(ctx.formParamAsClass("password", String.class).get());
        if (UsersRepository.existsByName(name) && password.equals(UsersRepository.findByName(name).getPassword())) {
            ctx.sessionAttribute("name", name);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void index(Context ctx) {
        var name = ctx.sessionAttribute("name");
        var page = new MainPage(name);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    // END
}
