package com.inspection.element;

import com.inspection.model.Dependency;
import com.inspection.visitor.ProjectVisitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DependencyFile implements ProjectElement {
    private final String name;
    private final int linesOfCode;
    private final List<Dependency> dependencies;

    public DependencyFile(String name, int linesOfCode, List<Dependency> dependencies) {
        this.name = name;
        this.linesOfCode = linesOfCode;
        this.dependencies = dependencies != null ? new ArrayList<>(dependencies) : new ArrayList<>();
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() { return name; }
    public int getLinesOfCode() { return linesOfCode; }
    public List<Dependency> getDependencies() { return Collections.unmodifiableList(dependencies); }
}