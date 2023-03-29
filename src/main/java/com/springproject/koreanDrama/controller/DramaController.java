package com.springproject.koreanDrama.controller;


import com.springproject.koreanDrama.model.Drama;
import com.springproject.koreanDrama.repository.DramaRepository;
import com.springproject.koreanDrama.service.DramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

    @RestController
    @RequestMapping("/dramas")
    public class DramaController {

        @Autowired
        DramaService dramaService;

        @Autowired
        DramaRepository dramaRepository;

        @GetMapping("")
        public ResponseEntity<?> getAllDramas() {
            return new ResponseEntity<> (dramaService.getAllDramas(), HttpStatus.OK);
        }


    @GetMapping("/{id}")
    public Drama getDrama(@PathVariable long id) {
        Drama dramaResponse = (Drama) dramaService.getDrama(id);
        return dramaResponse;
    }

    @GetMapping(value = "/titles/{title}")
    public List<Drama> getTitle(@PathVariable String title) {
        return dramaService.findByTitle(title);
    }
        @PostMapping("/")
        public ResponseEntity<Object> create(@RequestBody Map<String, Object> map) {
            try {
                dramaService.create(map);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create data: " + e.getMessage());
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Map<String, Object> map) throws Exception {
            Optional<Drama> dramaOptional = dramaRepository.findById(id);
            if (dramaOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Drama drama = dramaOptional.get();
            if (map.containsKey("title")) {
                drama.title = map.get("title").toString();
            }
            if (map.containsKey("year")) {
                drama.year = map.get("year").hashCode();
            }
            if (map.containsKey("aired_date")) {
                drama.aired_date = map.get("aired_date").toString();
            }
            if (map.containsKey("aired_on")) {
                drama.aired_on = map.get("aired_on").toString();
            }
            if (map.containsKey("number_of_episode")) {
                drama.number_of_episode = map.get("number_of_episode").hashCode();
            }
            if (map.containsKey("network")) {
                drama.network = map.get("network").toString();
            }
            if (map.containsKey("duration")) {
                drama.duration = map.get("duration").toString();
            }
            if (map.containsKey("genre")) {
                drama.genre = map.get("genre").toString();
            }
            if (map.containsKey("rating")) {
                drama.rating = map.get("rating").hashCode();
            }
            dramaRepository.save(drama);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteDrama(@PathVariable("id") long id) {
            dramaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

