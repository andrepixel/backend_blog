package com.andrepixel.backend_blog.dtos;

import java.util.Objects;

public class ContentDTO {
    private String image;

    public ContentDTO() {
    }

    public ContentDTO(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ContentDTO{" + "image='" + image + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ContentDTO that = (ContentDTO) o;
        return Objects.equals(
                image,
                that.image
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
