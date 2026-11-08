package com.inspection.element;

import com.inspection.visitor.ProjectVisitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory implements ProjectElement {
    private final String name;
    private final List<ProjectElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() { return name; }

    public void addElement(ProjectElement element) {
        if (element != null) {
            children.add(element);
        }
    }

    public List<ProjectElement> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }
}