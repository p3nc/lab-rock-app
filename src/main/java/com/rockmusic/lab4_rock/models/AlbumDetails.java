package com.rockmusic.lab4_rock.models;
import jakarta.persistence.*;

@Entity
public class AlbumDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recordLabel;
    private String producer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}