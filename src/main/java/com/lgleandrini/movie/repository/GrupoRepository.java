package com.lgleandrini.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgleandrini.movie.entity.GrupoEntity;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, Long>{
	
	
}
