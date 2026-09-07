package DesignPatterns.Structural.Composite;

import java.util.*;

interface FileSystemItem {

    void showDetails();
}

class File implements FileSystemItem {
    private String name;
    public File(String name) {
        this.name = name;
    }
    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Directory implements FileSystemItem {

    private String name;
    private List<FileSystemItem> items = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }
    public void add(FileSystemItem item) {
        items.add(item);
    }
    public void remove(FileSystemItem item) {
        items.remove(item);
    }
    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemItem item : items) {
            item.showDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        File file1 = new File("resume.pdf");
        File file2 = new File("project.java");
        File file3 = new File("notes.txt");

        Directory projects = new Directory("Projects");
        projects.add(file2);
        projects.add(file3);

        Directory documents = new Directory("Documents");
        documents.add(file1);
        documents.add(projects);

        documents.showDetails();
    }
}