package com.tcy.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcy.core.entity.LongPKEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 80002023 on 2016/6/21.
 */
@Entity
@Table(name = "BLOG_COMMENT")
@DynamicUpdate
public class BlogComment extends LongPKEntity {

    @Column(name = "CONTENT", length = 500)
    private String content;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "comments", fetch = FetchType.LAZY)
    private List<BlogArticle> articles;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<BlogArticle> articles) {
        this.articles = articles;
    }
}
