package com.anpora.erbhub.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rafael Barbieru, Popular Belbase, Anton Kamenov
 * Entity class for an actor
 */
@Entity
@Data
@Table(name = "actors")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "alias")
    private String alias;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String imageURL;

    @JoinTable(
            name = "actors_social_media",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "social_media_id")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SocialMediaEntity> socialMedia;

}
