package model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "image_id")
    private int imageId;
    private int lever;
    private String author;
    private String content;
    @Column(name = "like_count")
    private int likeCount;

    public Comment() {
    }

    public Comment(int imageId, int lever, String author, String content, int likeCount) {
        this.imageId = imageId;
        this.lever = lever;
        this.author = author;
        this.content = content;
        this.likeCount = likeCount;
    }

    public Comment(int id, int imageId, int lever, String author, String content, int likeCount) {
        this.id = id;
        this.imageId = imageId;
        this.lever = lever;
        this.author = author;
        this.content = content;
        this.likeCount = likeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
