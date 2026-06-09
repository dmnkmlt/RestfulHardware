package hr.java.spring.boot.University.domain;

public enum University {
    GEOF("GEOF"),
    ALU("ALU"),
    PMF("PMF");

    private final String fullName;

    University(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public static University fromFullName(String fullName) {
        for (University u : values()) {
            if (u.getFullName().equalsIgnoreCase(fullName)) {
                return u;
            }
        }
        throw new IllegalArgumentException("Non-existent uni");
    }
}
