package com.example.fileApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Nicolas on 09/04/2017.
 */
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    @Query("update ImageEntity set title = :new_title where id = :id")
    @Modifying
    int updateTitle(@Param("new_title") String title, @Param("id") Long id);

    @Query("update ImageEntity set likescore = :new_like where id = :id")
    @Modifying
    int updateLike(@Param("new_like") Integer likescore, @Param("id") Long id);

    @Query("update ImageEntity set dislikescore = :new_dislike where id = :id")
    @Modifying
    int updateDislike(@Param("new_dislike") Integer dislikescore, @Param("id") Long id);

    Optional<ImageEntity> findByTitle(String title);

    Optional<ImageEntity> findById(Long id);

    //Page<ImageEntity> findByToken(Token token,Pageable pageable);

}