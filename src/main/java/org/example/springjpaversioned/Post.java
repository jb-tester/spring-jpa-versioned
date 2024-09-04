package org.example.springjpaversioned;

import jakarta.persistence.*;

@Entity(name = "Post")
@Table(name = "post")
public class Post {
 
    @Id
    private Long id;
 
    private String title;
 
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "tinyint")
    private PostStatus status = PostStatus.PENDING;
 
    @Version
    private short version;
 
    public Long getId() {
        return id;
    }
 
    public Post setId(Long id) {
        this.id = id;
        return this;
    }
 
    public String getTitle() {
        return title;
    }
 
    public Post setTitle(String title) {
        this.title = title;
        return this;
    }
 
    public PostStatus getStatus() {
        return status;
    }
 
    public void setStatus(PostStatus status) {
        this.status = status;
    }
 
    public short getVersion() {
        return version;
    }
 
    public Post setVersion(short version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return "Post{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", status=" + status +
               ", version=" + version +
               '}';
    }
}
