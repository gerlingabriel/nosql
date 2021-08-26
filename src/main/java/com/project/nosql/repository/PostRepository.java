package com.project.nosql.repository;

import java.util.Date;
import java.util.List;

import com.project.nosql.model.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContainingIgnoreCase (String title);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);

    @Query(" { $and: ["
                + " {date: {$gte: ?1} }, { date: { $lte: ?2} } ," 
            + " { $or: "
                + " [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } },  { 'comments.text': { $regex: ?0, $options: 'i' } } ]"
            + " } " 
            + " ] } ")
    List<Post> fullserach(String text, Date minDate, Date maxDate);

}
