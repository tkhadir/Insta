package com.example.fileApi;

import com.example.post.CommentEntity;
import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by Nicolas on 09/04/2017.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @Column
    @GeneratedValue
    private Long id;


    @Column
    private String title;

    @Column
    private Integer likescore;

    @Column
    private Integer dislikescore;

    @ManyToOne(cascade= ALL)
    @JoinColumn(name = "album", referencedColumnName="id_album")
    private AlbumEntity album;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "image")
    private List<CommentEntity> commentEntityList;

}