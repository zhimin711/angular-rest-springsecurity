package com.tcy.blog.repository;

import com.tcy.blog.entity.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 80002023 on 2016/6/21.
 */
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {
}
