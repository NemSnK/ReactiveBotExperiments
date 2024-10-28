package org.example.model;

import org.springframework.data.annotation.Id;


public class Chats {
    @Id
    private Long id;

    private String title;

    private String description;

    private boolean published;

    public Chats() {

    }

    public Chats(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
