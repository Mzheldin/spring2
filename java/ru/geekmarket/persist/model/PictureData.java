package com.geekbrains.spring2.persist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pictures_data")
public class PictureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "data", nullable = false, columnDefinition="MEDIUMBLOB")
    private byte[] data;

    public PictureData() {
    }

    public PictureData(byte[] data) {
        this.data = data;
    }
}
