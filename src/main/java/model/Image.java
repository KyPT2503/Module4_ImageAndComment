package model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String src;
    @Transient
    private MultipartFile file;
    @OneToMany
    private List<Comment> comments;

    public Image() {
    }

    public Image(String src, MultipartFile file) {
        this.src = src;
        this.file = file;
    }

    public Image(int id, String src, MultipartFile file) {
        this.id = id;
        this.src = src;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
