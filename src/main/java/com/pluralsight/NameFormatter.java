
package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {
    }

    // Format first name and last name
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // Format all five name components
    public static String format(String prefix, String firstName,
                                String middleName, String lastName,
                                String suffix) {

        String name = lastName + ", ";

        if (prefix != null && !prefix.isBlank()) {
            name += prefix.trim() + " ";
        }

        name += firstName;

        if (middleName != null && !middleName.isBlank()) {
            name += " " + middleName.trim();
        }

        if (suffix != null && !suffix.isBlank()) {
            name += ", " + suffix.trim();
        }

        return name;
    }

    // Format a full name supplied as one String
    public static String format(String fullName) {

        String[] parts = fullName.trim().split("\\s+");

        String prefix = "";
        String firstName;
        String middleName = "";
        String lastName;
        String suffix = "";

        int start = 0;

        if (parts[0].endsWith(".")) {
            prefix = parts[0];
            start = 1;
        }

        int end = parts.length;

        if (parts[end - 1].startsWith(",") || fullName.contains(",")) {
            suffix = parts[end - 1];
            if (suffix.startsWith(",")) {
                suffix = suffix.substring(1);
            }
            end--;
        }

        firstName = parts[start];
        lastName = parts[end - 1].replace(",", "");

        if (end - start > 2) {
            StringBuilder middle = new StringBuilder();

            for (int i = start + 1; i < end - 1; i++) {
                if (middle.length() > 0) {
                    middle.append(" ");
                }
                middle.append(parts[i]);
            }

            middleName = middle.toString();
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}
