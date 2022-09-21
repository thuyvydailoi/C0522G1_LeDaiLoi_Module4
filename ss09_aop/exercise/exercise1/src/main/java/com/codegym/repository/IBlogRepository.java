package com.codegym.repository;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    Page<Blog> findAllByBlogNameContaining(String title, Pageable pageable);

    @Query(value = "SELECT b.blog_name as blogName, c.category_name as categoryName " +
            "FROM blog b join category c on b.category_id = c.category_id",
            nativeQuery= true)
    List<BlogDto> showList();
}
