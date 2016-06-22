package com.tcy.rest.resource;

import com.tcy.blog.entity.BlogArticle;
import com.tcy.blog.service.BlogArticleService;
import com.tcy.app.JsonViews;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;


@Component
@Path("/blog/article")
public class BlogArticleResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogArticleService blogArticleService;

    @Autowired
    private ObjectMapper mapper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws JsonGenerationException, JsonMappingException, IOException {
        this.logger.info("list()");
        ObjectWriter viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
        List<BlogArticle> records = blogArticleService.findAll();

        return viewWriter.writeValueAsString(records);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public BlogArticle read(@PathParam("id") Long id) {
        this.logger.info("read({})", id);

        BlogArticle article = this.blogArticleService.find(id);
        if (article == null) {
            throw new WebApplicationException(404);
        }
        return article;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BlogArticle create(BlogArticle record) {
        this.logger.info("create():{} ", record);

        return this.blogArticleService.saveOrUpdate(record);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public BlogArticle update(@PathParam("id") Long id, BlogArticle record) {

        this.logger.info("update():{} ", record);

        return this.blogArticleService.saveOrUpdate(record);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        this.logger.info("delete({})", id);

        this.blogArticleService.delete(id);
    }

}