package com.br.livedwine.model;

import com.br.livedwine.enumerated.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_name"}, name = "user_name_unique_idx"))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    private Integer age;

    private String profession;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
