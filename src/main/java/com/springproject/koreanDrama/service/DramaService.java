package com.springproject.koreanDrama.service;

import com.springproject.koreanDrama.model.Drama;
import com.springproject.koreanDrama.repository.DramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class DramaService {

    @Autowired
    DramaRepository dramaRepository;


    public List<Drama> getAllDramas() {

        return dramaRepository.findAll();
    }


    public Drama getDrama(long id ) {

        Optional<Drama> dramaResponse =  dramaRepository.findById(id);
        Drama drama = dramaResponse.get();
        return drama;
    }

    public List<Drama> findByTitle(String title) {

        return dramaRepository.findByTitle(title);
    }


    public void create(Map<String, Object> map) {

        Drama drama = new Drama();

        drama.title = map.get("title").toString();
        drama.year = map.get("year").hashCode();
        drama.aired_date = map.get("aired_date").toString();
        drama.aired_on = map.get("aired_on").toString();
        drama.number_of_episode = map.get("number_of_episode").hashCode();
        drama.network = map.get("network").toString();
        drama.duration = map.get("duration").toString();
        drama.genre = map.get("genre").toString();
        drama.rating = map.get("rating").hashCode();

        dramaRepository.save(drama);
    }


   public ResponseEntity<?> update(Long id, Map<String, Object> map) throws Exception {

        Optional<Drama> dramaOptional = dramaRepository.findById(id);

        if (dramaOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Drama drama = dramaOptional.get();

        drama.title = map.get("title").toString();
        drama.year = map.get("year").hashCode();
        drama.aired_date = map.get("aired_date").toString();
        drama.aired_on = map.get("aired_on").toString();
        drama.number_of_episode = map.get("number_of_episode").hashCode();
        drama.network = map.get("network").toString();
        drama.duration = map.get("duration").toString();
        drama.genre = map.get("genre").toString();
        drama.rating = map.get("rating").hashCode();


        dramaRepository.save(drama);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public void delete(long id) {
        dramaRepository.deleteById(id);
    }

}
