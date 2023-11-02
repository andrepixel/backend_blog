package com.andrepixel.backend_blog.dtos;

import java.util.Objects;

public class ProfileDTO {
    private String profileImage;

    public ProfileDTO(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProfileDTO that = (ProfileDTO) o;
        return Objects.equals(
                profileImage,
                that.profileImage
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileImage);
    }

    @Override
    public String toString() {
        return "ProfileDTO{" + "profileImage='" + profileImage + '\'' + '}';
    }
}