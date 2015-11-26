package com.example.shiva.gallery500px;

/**
 * Created by shiva on 22-11-2015.
 */
public class ImagePx {
    String imageUrl_Thumbnail,title,author;

    @Override
    public String toString() {
        return "ImagePx{" +
                "imageUrl_Thumbnail='" + imageUrl_Thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getImageUrl_Thumbnail() {
        return imageUrl_Thumbnail;
    }

    public void setImageUrl_Thumbnail(String imageUrl_Thumbnail) {
        this.imageUrl_Thumbnail = imageUrl_Thumbnail;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
    