package com.andrepixel.backend_blog.dtos;

import java.util.Objects;

public class ContentDTO {
    private String image;

    public ContentDTO() {
    }

    public ContentDTO(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ContentDTO image(String image) {
        setImage(image);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContentDTO)) {
            return false;
        }
        ContentDTO contentDTO = (ContentDTO) o;
        return Objects.equals(image, contentDTO.image);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(image);
    }

    @Override
    public String toString() {
        return "{" +
            " image='" + getImage() + "'" +
            "}";
    }
    
}
