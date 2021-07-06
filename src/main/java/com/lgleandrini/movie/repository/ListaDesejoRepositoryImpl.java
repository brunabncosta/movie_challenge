package com.lgleandrini.movie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lgleandrini.movie.model.ListaDesejoModel;

@Repository
@Transactional(readOnly = true)
public class ListaDesejoRepositoryImpl {

	@PersistenceContext
	public EntityManager entityManager;

	public List<ListaDesejoModel> buscarFiltro(String idUsuario, String genero, String autor, String diretor) {
		StringBuilder sql = new StringBuilder("SELECT new com.lgleandrini.movie.model.ListaDesejoModel(l.titulo, l.genero, l.ator, l.diretor, l.imdbID) "
				+ "FROM ListaDesejoEntity l WHERE l.usuarioEntity.id = " + idUsuario);

		if (diretor != null) {
			sql.append(" AND l.diretor LIKE '%"+diretor+"%'");
		}
		if (genero != null) {
			sql.append(" AND l.genero LIKE '%"+genero+"%'");
		}
		if (autor != null) {
			sql.append(" AND l.ator LIKE '%"+autor+"%'");
		}

		Query query = entityManager.createQuery(sql.toString());
		try {
			List resultList = query.getResultList();
			return resultList;
		} catch (Exception e) {
			return null;
		}
	}

}
