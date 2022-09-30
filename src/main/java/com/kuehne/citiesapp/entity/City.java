package com.kuehne.citiesapp.entity;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    @NonNull
    @Column(name = "name", length = 30)
    String name;

    @Column(name = "image",columnDefinition="LONGTEXT")
    String image;
}
