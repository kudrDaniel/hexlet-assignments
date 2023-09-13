package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        Javalin app = Javalin.create(config -> config.plugins.enableDevLogging());

        app.get("/phones", ctx -> ctx.json(phones, List.class));
        app.get("/domains", ctx -> ctx.json(domains, List.class));

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
