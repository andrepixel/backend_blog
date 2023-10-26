package com.andrepixel.backend_blog.dtos;

import java.util.List;
import java.util.Objects;

public class ProjectDTO {
    private String title;
    private List<String> tags;
    private List<String> images;
    private List<String> text;

    public ProjectDTO() {
    }

    public ProjectDTO(
            String title,
            List<String> tags,
            List<String> images,
            List<String> text
    ) {
        this.title = title;
        this.tags = tags;
        this.images = images;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProjectDTO that = (ProjectDTO) o;
        return Objects.equals(
                title,
                that.title
        ) && Objects.equals(
                tags,
                that.tags
        ) && Objects.equals(
                images,
                that.images
        ) && Objects.equals(
                text,
                that.text
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                title,
                tags,
                images,
                text
        );
    }

    @Override
    public String toString() {
        return "ProjectDTO{" + "title='" + title + '\'' + ", tags=" + tags +
                ", images=" + images + ", text=" + text + '}';
    }
}
