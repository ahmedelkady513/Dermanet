package com.dermanet.backend.utilities;

import org.springframework.security.core.context.SecurityContextHolder;


public final class CurrentUserUtils {

    private CurrentUserUtils() {}
    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
