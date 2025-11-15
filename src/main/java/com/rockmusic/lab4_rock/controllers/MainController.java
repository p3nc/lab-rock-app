package com.rockmusic.lab4_rock.controllers;

import com.rockmusic.lab4_rock.models.Album;
import com.rockmusic.lab4_rock.models.AlbumDetails;
import com.rockmusic.lab4_rock.models.Band;
import com.rockmusic.lab4_rock.models.Song;
import com.rockmusic.lab4_rock.repo.AlbumDetailsRepository;
import com.rockmusic.lab4_rock.repo.AlbumRepository;
import com.rockmusic.lab4_rock.repo.BandRepository;
import com.rockmusic.lab4_rock.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private BandRepository bandRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumDetailsRepository albumDetailsRepository;
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Band> bands = bandRepository.findAll();
        Iterable<Album> albums = albumRepository.findAll();
        Iterable<Song> songs = songRepository.findAll();

        model.addAttribute("bands", bands);
        model.addAttribute("albums", albums);
        model.addAttribute("songs", songs);

        return "home";
    }

    @PostMapping("/add-band")
    public String addBand(@RequestParam String name,
                          @RequestParam String originCountry,
                          @RequestParam int yearFormed) {

        Band newBand = new Band();
        newBand.setName(name);
        newBand.setOriginCountry(originCountry);
        newBand.setYearFormed(yearFormed);

        bandRepository.save(newBand);

        return "redirect:/";
    }

    @PostMapping("/add-album")
    public String addAlbum(@RequestParam String title,
                           @RequestParam int releaseYear,
                           @RequestParam Long band_id,
                           @RequestParam String recordLabel,
                           @RequestParam String producer) {

        Band band = bandRepository.findById(band_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid band Id:" + band_id));

        AlbumDetails details = new AlbumDetails();
        details.setRecordLabel(recordLabel);
        details.setProducer(producer);
        albumDetailsRepository.save(details);

        Album newAlbum = new Album();
        newAlbum.setTitle(title);
        newAlbum.setReleaseYear(releaseYear);
        newAlbum.setBand(band);
        newAlbum.setAlbumDetails(details);

        albumRepository.save(newAlbum);

        return "redirect:/";
    }

    @PostMapping("/add-song")
    public String addSong(@RequestParam String title,
                          @RequestParam String duration,
                          @RequestParam Long album_id) {

        Album album = albumRepository.findById(album_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid album Id:" + album_id));

        Song newSong = new Song();
        newSong.setTitle(title);
        newSong.setDuration(duration);
        newSong.setAlbum(album);

        songRepository.save(newSong);

        return "redirect:/";
    }
}