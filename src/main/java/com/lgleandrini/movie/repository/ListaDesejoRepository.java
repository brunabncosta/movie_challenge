package com.lgleandrini.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgleandrini.movie.entity.ListaDesejoEntity;

@Repository
public interface ListaDesejoRepository extends JpaRepository<ListaDesejoEntity, Long>{
	
	public List<ListaDesejoEntity> findByDiretor(String diretor);
	
}
