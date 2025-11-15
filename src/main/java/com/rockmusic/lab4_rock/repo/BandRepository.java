package com.rockmusic.lab4_rock.repo;
import com.rockmusic.lab4_rock.models.Band;
import org.springframework.data.repository.CrudRepository;
public interface BandRepository extends CrudRepository<Band, Long> {}