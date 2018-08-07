package org.treadstone.jenkins.analyzer;

public class Failure {

    private Users author;
    private String alias;
    private String group;
    private String name;
    private Projects project;

    public Failure(Users author, String group, String name, Projects project, String alias) {
        super();
        this.author = author;
        this.group = group;
        this.name = name;
        this.project = project;
        this.alias = alias;
        System.out.println("Creating failure:" + toString());
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "{" + author + ", " + group + ", " + name + ", " + project + ", " + alias + "}";
    }

}
