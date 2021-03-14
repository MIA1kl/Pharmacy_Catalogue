package com.midapp.spring_app.repo;

import com.midapp.spring_app.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
