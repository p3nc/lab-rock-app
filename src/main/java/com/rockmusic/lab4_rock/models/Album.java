package com.rockmusic.lab4_rock.models;
import jakarta.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;

    @ManyToOne
    private Band band;

    @OneToOne
    private AlbumDetails albumDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public AlbumDetails getAlbumDetails() {
        return albumDetails;
    }

    public void setAlbumDetails(AlbumDetails albumDetails) {
        this.albumDetails = albumDetails;
    }
}