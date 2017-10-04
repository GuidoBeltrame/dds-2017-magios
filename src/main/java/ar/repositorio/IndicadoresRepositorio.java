package ar.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.entidades.Indicador;

public class IndicadoresRepositorio extends Repositorio{

	public IndicadoresRepositorio(EntityManager em) {
		super(em);
	}
	
	public Indicador buscarPorId(Long id) {
		return em.find(Indicador.class, id);
	}
	
	public void persistir(Indicador indicador) {
		em.getTransaction().begin();
		em.persist(indicador);
		em.getTransaction().commit();
	}
	
	public List<Indicador> getIndicadores() {
		Query query = em.createQuery("SELECT i FROM Indicador i");
		return query.getResultList();
	}
}