package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
 @Query(value = "select * from blog where title like concat('%' :title '%')",nativeQuery = true)
    List<Blog> searchTitle(@Param("title")String title);
}
