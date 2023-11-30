package exercise;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        int max = 30;
        app.get("/users", ctx -> {
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1) - 1;
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            int from, to;
            if (per < 1 || per > max) {
                per = 5;
            }
            if (page < 0) {
                page = 0;
            }
            if (max % per == 0 && page + 1 >= max / (page + 1)
                    || max % per != 0 && page + 1 > max / (page + 1)) {
                page = 0;
            }
            from = page * per;
            if (max % per == 0) {
                to = Math.min(page * per + per, max);
            } else {
                to = Math.min(page * per + per, page * per + (max - page * per));
            }
            ctx.json(USERS.subList(from, to), List.class);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7075);
    }
}
