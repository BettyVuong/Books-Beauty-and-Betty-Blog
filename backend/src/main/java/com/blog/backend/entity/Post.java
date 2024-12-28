package com.blog.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "posts")
public class Post{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
  @Column(name = "Id")
  private Long id; // Define the primary key field
  @Column(name = "Category", nullable = false, length = 255)
  private String category;
 @Column(name = "Title", nullable = false, length = 255)
  private String title;
  @Column(name = "Date", nullable = false)
  private LocalDate date;
  @Lob
  @Column(name = "Image", columnDefinition = "LONGBLOB")
  private byte[] image;
 @Column(name = "Blurb", length = 255)
  private String blurb;
 @Column(name = "Content", nullable = false, columnDefinition = "TEXT")
  private String content;

  // Constructor
  public Post() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public String getBlurb() {
    return blurb;
  }

  public void setBlurb(String blurb) {
    this.blurb = blurb;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
