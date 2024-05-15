package main.com.batsworks.interfaces.config.styles;

import java.awt.Font;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class FontStyle extends Font {

    private static final String DEFAULT_FONT = "Arial Black";

    public FontStyle(String name, int style, int size) {
        super(name, style, size);
    }

    public FontStyle(int style, int size) {
        super(DEFAULT_FONT, style, size);
    }

    public FontStyle(int size) {
        super(DEFAULT_FONT, Font.PLAIN, size);
    }

    public FontStyle(String font) {
        super(font, Font.PLAIN, 12);
    }

    public FontStyle() {
        super(DEFAULT_FONT, Font.PLAIN, 14);
    }

    public FontStyle(Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        super(attributes);
    }

    protected FontStyle(Font font) {
        super(font);
    }

}
