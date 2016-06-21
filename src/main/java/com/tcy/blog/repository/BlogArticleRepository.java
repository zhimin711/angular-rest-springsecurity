package com.tcy.blog.repository;

import com.tcy.blog.entity.BlogArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 80002023 on 2016/6/21.
 */
public interface BlogArticleRepository extends JpaRepository<BlogArticle, Long> {
}
