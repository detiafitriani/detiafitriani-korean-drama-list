package com.springproject.koreanDrama.repository;

import com.springproject.koreanDrama.model.Drama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DramaRepository extends JpaRepository<Drama, Long> {

    List<Drama> findByTitle(String title);


}
