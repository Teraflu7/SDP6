package com.inspection.model;

public class Dependency {
    private final String artifactId;
    private final String version;
    private final String license;
    private final boolean vulnerable;
    private final boolean prohibited;

    public Dependency(String artifactId, String version, String license, boolean vulnerable, boolean prohibited) {
        this.artifactId = artifactId;
        this.version = version;
        this.license = license;
        this.vulnerable = vulnerable;
        this.prohibited = prohibited;
    }

    public String getArtifactId() { return artifactId; }
    public String getVersion() { return version; }
    public String getLicense() { return license; }
    public boolean isVulnerable() { return vulnerable; }
    public boolean isProhibited() { return prohibited; }

    public boolean hasSpecifiedVersion() {
        return version != null && !version.trim().isEmpty() && !version.equalsIgnoreCase("RELEASE") && !version.equalsIgnoreCase("LATEST");
    }

    @Override
    public String toString() {
        return artifactId + ":" + (version != null && !version.isEmpty() ? version : "UNSPECIFIED") + " (" + license + ")";
    }
}