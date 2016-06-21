package com.tcy.blog.service.impl;

import com.tcy.blog.entity.BlogArticle;
import com.tcy.blog.repository.BlogArticleRepository;
import com.tcy.blog.service.BlogArticleService;
import com.tcy.core.http.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 80002023 on 2016/6/21.
 */
@Service
public class BlogArticleServiceImpl implements BlogArticleService {


    @Autowired
    private BlogArticleRepository blogArticleRepository;

    @Override
    public BlogArticle saveOrUpdate(BlogArticle record) {
        return blogArticleRepository.save(record);
    }

    @Override
    public List<BlogArticle> saveOrUpdate(List<BlogArticle> records) {
        return blogArticleRepository.save(records);
    }

    @Override
    public void delete(Long id) {
        blogArticleRepository.delete(id);
    }

    @Override
    public void delete(List<BlogArticle> records) {
        blogArticleRepository.delete(records);
    }

    @Override
    public BlogArticle find(Long id) {
        return blogArticleRepository.findOne(id);
    }

    @Override
    public List<BlogArticle> find(BlogArticle record) {
        return null;
    }

    @Override
    public PageResult<BlogArticle> findPage(BlogArticle record, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<BlogArticle> findAll() {
        return blogArticleRepository.findAll();
    }
}
