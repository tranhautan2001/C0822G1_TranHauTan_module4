package com.example.ss11_web_service.repository;


import com.example.ss11_web_service.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
 @Query(value = "select * from blog where title like concat('%' :title '%')",nativeQuery = true)
  Page<Blog> searchTitle(@Param("title")String title, Pageable pageable);

 Boolean findByTitle(boolean title);

 @Query(value = "select * from blog where category_id =:id  ",nativeQuery = true)
 List<Blog> findByBlog(@Param("id")int id);


 @Query(value = "select * from blog where id =:id  ",nativeQuery = true)
 List<Blog> viewBlog(@Param("id")int id);
}
