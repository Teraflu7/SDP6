package com.inspection.element;

import com.inspection.visitor.ProjectVisitor;

public class TestFile implements ProjectElement {
    private final String name;
    private final int linesOfCode;
    private final int testCount;
    private final String targetSourceFile;
    private final String framework;

    public TestFile(String name, int linesOfCode, int testCount, String targetSourceFile, String framework) {
        this.name = name;
        this.linesOfCode = linesOfCode;
        this.testCount = testCount;
        this.targetSourceFile = targetSourceFile;
        this.framework = framework;
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() { return name; }
    public int getLinesOfCode() { return linesOfCode; }
    public int getTestCount() { return testCount; }
    public String getTargetSourceFile() { return targetSourceFile; }
    public String getFramework() { return framework; }
}