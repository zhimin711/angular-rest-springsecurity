package com.tcy.blog.entity;

import com.tcy.core.base.LongPKEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 80002023 on 2016/6/21.
 */

@Entity
@Table(name = "BLOG_ARTICLE")
@DynamicUpdate
public class BlogArticle extends LongPKEntity {

    @Lob
    @Column(name = "CONTENT")
    private String content;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "BLOG_ARTICLE_COMMENT", joinColumns = {@JoinColumn(name = "ARTICLE_ID")}, inverseJoinColumns = {@JoinColumn(name = "COMMENT_ID")})
    private List<BlogComment> comments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }
}
