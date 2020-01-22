package com.example;

import java.util.List;

public class Node {

    private String id;

    private String name;

    private String condition;

    private String action;

    private boolean containElse;

    private List<Node> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isContainElse() {
        return containElse;
    }

    public void setContainElse(boolean containElse) {
        this.containElse = containElse;
    }

    private boolean hasElseStatement() {
        return containElse;
    }
}
