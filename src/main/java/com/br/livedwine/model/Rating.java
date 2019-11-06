package com.br.livedwine.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author Lucas Copque
 * @version 1.0
 * @since 06/11/2019
 */
@Entity
@DynamicUpdate
@Getter
@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"wine_id", "user_id"}, name = "wine_id_user_id_unique_idx"))
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;
}
