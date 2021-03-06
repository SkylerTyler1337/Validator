package me.Elliott_.Validator.modules.regions.type;

import me.Elliott_.Validator.exceptions.UnknownAttributeException;
import me.Elliott_.Validator.modules.PGMElement;
import org.jdom2.Attribute;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class Point extends PGMElement {

    private final Element element;

    public Point(Element element) {
        this.element = element;
    }

    private final List<String> attributes = Arrays.asList("region", "yaw", "pitch", "angle");

    @Override
    public void validate() throws Exception {
        if (element.getName().equals("point")) {
            for (Attribute attribute : element.getAttributes()) {
                if (!attributes.contains(attribute.getName())) throw new UnknownAttributeException(element, attribute);
            }
        }
    }
}
