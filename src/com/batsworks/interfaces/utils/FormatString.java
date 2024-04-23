package com.batsworks.interfaces.utils;

public final class FormatString {

    FormatString() {
        throw new IllegalStateException("Utility class");
    }

    public static String forDb(Class<?> t) {
        var string = t.getName().replace(t.getPackageName(), "").toLowerCase();
        string = string.replace("model", "");
        return string.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
}
