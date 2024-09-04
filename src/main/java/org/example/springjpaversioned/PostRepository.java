package org.example.springjpaversioned;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * *
 * <p>Created by Irina on 9/4/2024.</p>
 * *
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select e from Post e")
    List<Post> allPosts();

    @Modifying
    @Query("update versioned Post p set p.status = :newStatus, p.title = :newTitle where p.status = :oldStatus and lower(p.title) like :pattern")
    void bulkPostsUpdate(@Param("newStatus") PostStatus newStatus, @Param("oldStatus") PostStatus oldStatus, @Param("pattern") String pattern, @Param("newTitle") String newTitle);
}
