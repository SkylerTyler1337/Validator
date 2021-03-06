package me.Elliott_.Validator.modules.regions;

import me.Elliott_.Validator.exceptions.UnknownElementException;
import me.Elliott_.Validator.modules.ElementBuilder;
import me.Elliott_.Validator.modules.PGMElement;
import me.Elliott_.Validator.modules.authors.Author;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class Regions extends PGMElement {

    private final Element element;

    public Regions(Element element) {
        this.element = element;
    }

    private final List<String> allowedElements = Arrays.asList("rectangle", "cuboid", "cylinder", "sphere", "block", "point", "empty", "negative", "complement", "union", "intersect", "apply", "region");

    @Override
    public void validate() throws Exception {
        if (element.getName().equals("regions")) {
            if (element.getChildren() != null) {
                for (Element child : element.getChildren()) {
                    if (allowedElements.contains(child.getName())) {
                        PGMElement PGMChild = ElementBuilder.getPGMElement(child);
                        if (PGMChild != null) {
                            PGMChild.validate();
                        } else throw new UnknownElementException(child);
                    } else throw new UnknownElementException(child);
                }
            }
        }
    }
}
