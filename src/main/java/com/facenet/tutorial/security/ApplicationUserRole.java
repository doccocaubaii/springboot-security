package com.facenet.tutorial.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.facenet.tutorial.security.ApplicationUserPermission.*;

@RequiredArgsConstructor
@Getter
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(COURSE_READ,  STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;
}
