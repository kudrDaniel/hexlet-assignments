package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public final class PairedTag extends Tag {
    private final String text;

    private final List<Tag> children = new ArrayList<>();

    public PairedTag(
            String name,
            Map<String, String> attributes,
            String text,
            List<Tag> children
    ) {
        super(name, attributes);
        this.text = text;
        this.children.addAll(children);
    }

    @Override
    public String toString() {
        return "<" + super.getName()
                + super.attributesToString() + ">"
                + this.text
                + children.stream()
                .map(Object::toString)
                .collect(Collectors.joining())
                + "</" + super.getName() + ">";
    }
}
// END
