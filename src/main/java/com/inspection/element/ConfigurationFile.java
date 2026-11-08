package com.inspection.element;

import com.inspection.visitor.ProjectVisitor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationFile implements ProjectElement {
    private final String name;
    private final int linesOfCode;
    private final Map<String, String> properties;
    private final boolean containsExposedSecrets;
    private final boolean encrypted;

    public ConfigurationFile(String name, int linesOfCode, Map<String, String> properties,
                             boolean containsExposedSecrets, boolean encrypted) {
        this.name = name;
        this.linesOfCode = linesOfCode;
        this.properties = properties != null ? new HashMap<>(properties) : new HashMap<>();
        this.containsExposedSecrets = containsExposedSecrets;
        this.encrypted = encrypted;
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() { return name; }
    public int getLinesOfCode() { return linesOfCode; }
    public Map<String, String> getProperties() { return Collections.unmodifiableMap(properties); }
    public boolean containsExposedSecrets() { return containsExposedSecrets; }
    public boolean isEncrypted() { return encrypted; }
    public boolean hasInsecureConfig() { return !encrypted || containsExposedSecrets; }
}