package com.rockmusic.lab4_rock.repo;
import com.rockmusic.lab4_rock.models.Album;
import org.springframework.data.repository.CrudRepository;
public interface AlbumRepository extends CrudRepository<Album, Long> {}