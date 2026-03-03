package com.xworkz.employee.constant;

/**
 * Enum representing fixed job roles within the organization.
 * Used for role-based access control and category filtering.
 */
public enum JobRole {

    DEVELOPER, TESTER, MANAGER, HR, ARCHITECT;

    /**
     * Static helper to log all available roles.
     * Useful for populating dropdowns in your UI.
     */
    public static void printAllRoles() {
        System.out.println("--- Registering Available Job Roles ---");
        for (JobRole role : JobRole.values()) {
            System.out.println("Role ID: " + role.ordinal() + " | Role Name: " + role.name());
        }
        System.out.println("---------------------------------------");
    }
}