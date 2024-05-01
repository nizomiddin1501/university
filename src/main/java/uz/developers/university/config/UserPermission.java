package uz.developers.university.config;

public enum UserPermission {


    ADDRESS_READ_ALL("address:readAll"),
    ADDRESS_READ_ONE("address:readOne"),
    ADDRESS_ADD("address:add"),
    ADDRESS_EDIT("address:edit"),
    ADDRESS_DELETE("address:delete"),

    FACULTY_READ_ALL("faculty:readAll"),
    FACULTY_READ_ALL_IN_UNIVERSITY("faculty:readAllInUniversity"),
    FACULTY_ADD("faculty:add"),
    FACULTY_EDIT("faculty:edit"),
    FACULTY_DELETE("faculty:delete"),

    GROUP_READ_ALL("group:readAll"),
    GROUP_READ_ALL_IN_UNIVERSITY("group:readAllInUniversity"),
    GROUP_READ_ALL_IN_FACULTY("group:readAllInFaculty"),
    GROUP_ADD("group:add"),
    GROUP_EDIT("group:edit"),
    GROUP_DELETE("group:delete"),

    STUDENT_READ_ALL("student:readAll"),
    STUDENT_READ_ALL_IN_UNIVERSITY("student:readAllInUniversity"),
    STUDENT_READ_ALL_IN_FACULTY("student:readAllInFaculty"),
    STUDENT_ADD("student:add"),
    STUDENT_EDIT("student:edit"),
    STUDENT_DELETE("student:delete"),

    SUBJECT_READ_ALL("subject:readAll"),
    SUBJECT_READ_ONE("subject:readOne"),
    SUBJECT_ADD("subject:add"),
    SUBJECT_EDIT("subject:edit"),
    SUBJECT_DELETE("subject:delete"),

    UNIVERSITY_READ_ALL("university:readAll"),
    UNIVERSITY_READ_ONE("university:readOne"),
    UNIVERSITY_ADD("university:add"),
    UNIVERSITY_EDIT("university:edit"),
    UNIVERSITY_DELETE("university:delete");



    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
