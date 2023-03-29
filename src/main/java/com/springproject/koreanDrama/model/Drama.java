package com.springproject.koreanDrama.model;

import jakarta.persistence.*;

@Entity
@Table(name = "korean_drama")
public class Drama {

    @Id
    @SequenceGenerator(name = "korean_drama_sequence", sequenceName = "korean_drama_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korean_drama_sequence")
    @Column(name = "id", updatable = true)
    public Long id;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "year")
    public Integer year;

    @Column(name = "aired_date")
    public String aired_date;

    @Column(name = "aired_on")
    public String aired_on;

    @Column(name = "number_of_episode")
    public Integer number_of_episode;

    @Column(name = "network")
    public String network;

    @Column(name = "duration")
    public String duration;

    @Column(name = "genre")
    public String genre;

    @Column(name = "rating")
    public double rating;


}

