package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass() + " bean has been created");
    }
    // END
}
