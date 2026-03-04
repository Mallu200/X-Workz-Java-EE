package com.xworkz.aqualink.enums;

/**
 * Enum to define the types of water connections in the AquaLink system.
 * This prevents invalid data entry and maps directly to the UI dropdowns.
 */
public enum ConnectionType {
    RESIDENTIAL("Residential"),
    COMMERCIAL("Commercial"),
    INDUSTRIAL("Industrial");

    private final String value;

    // Constructor to associate a human-readable string with the constant
    ConnectionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Utility to find an Enum by its string value.
     * Useful when receiving data from a React frontend or a CSV file.
     */
    public static ConnectionType fromString(String text) {
        for (ConnectionType type : ConnectionType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        System.err.println("AquaLink Warning: No enum constant found for " + text);
        return null;
    }

    @Override
    public String toString() {
        return this.value;
    }
}