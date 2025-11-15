package com.rockmusic.lab4_rock.repo;
import com.rockmusic.lab4_rock.models.Song;
import org.springframework.data.repository.CrudRepository;
public interface SongRepository extends CrudRepository<Song, Long> {}