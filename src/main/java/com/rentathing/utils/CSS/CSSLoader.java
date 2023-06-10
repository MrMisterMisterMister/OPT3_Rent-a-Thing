package com.rentathing.utils.CSS;

import java.util.Objects;

public class CSSLoader {
    public static String loadCSS(String cssPath) {
        return Objects.requireNonNull(CSSLoader.class.getResource(cssPath)).toExternalForm();
    }
}
