package com.rahansazeh.apiserver.utils;

public class ObjectEquals {
    private ObjectEquals() {
    }

    public static boolean equals(Object left, Object right) {
        if (left == null || right == null) {
            return left == null;
        }
        else {
            return left.equals(right);
        }
    }
}
