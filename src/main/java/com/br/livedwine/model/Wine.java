package com.br.livedwine.model;

import com.br.livedwine.enumerated.WineType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"wine_name"}, name = "wine_name_unique_idx"))
public class Wine implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wine_id")
    private Long id;

    @Column(name = "wine_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private WineType type;

    private String country;

    private String region;

    private Double alcoholContent;

    private String producer;

    private Integer service;

    private Integer volume;

    private Integer harvest;

    private String image;

    @ElementCollection
    @CollectionTable(name = "wine_grape", joinColumns = @JoinColumn(name = "wine_id"))
    private List<String> grape;

    @ElementCollection
    @CollectionTable(name = "wine_harmonization", joinColumns = @JoinColumn(name = "wine_id"))
    private List<String> harmonization;

}
