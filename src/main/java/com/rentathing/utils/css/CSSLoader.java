package com.rentathing.utils.css;

import java.util.Objects;

public class CSSLoader {
    public static String loadCSS(String cssPath) {
        return Objects.requireNonNull(CSSLoader.class.getResource(cssPath)).toExternalForm();
    }
}
