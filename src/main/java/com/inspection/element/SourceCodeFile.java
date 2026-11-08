package com.inspection.element;

import com.inspection.visitor.ProjectVisitor;

public class SourceCodeFile implements ProjectElement {
    private final String name;
    private final int linesOfCode;
    private final int cyclomaticComplexity;
    private final boolean hasHardcodedCredentials;
    private final boolean highRisk;
    private final String module;

    public SourceCodeFile(String name, int linesOfCode, int cyclomaticComplexity,
                          boolean hasHardcodedCredentials, boolean highRisk, String module) {
        this.name = name;
        this.linesOfCode = linesOfCode;
        this.cyclomaticComplexity = cyclomaticComplexity;
        this.hasHardcodedCredentials = hasHardcodedCredentials;
        this.highRisk = highRisk;
        this.module = module;
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visit(this); // Double Dispatch (1-й шаг: вызов перегруженного visit)
    }

    @Override
    public String getName() { return name; }
    public int getLinesOfCode() { return linesOfCode; }
    public int getCyclomaticComplexity() { return cyclomaticComplexity; }
    public boolean hasHardcodedCredentials() { return hasHardcodedCredentials; }
    public boolean isHighRisk() { return highRisk; }
    public String getModule() { return module; }
}