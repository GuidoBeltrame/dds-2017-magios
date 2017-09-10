package ar.repositorio;

import javax.persistence.EntityManager;

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
}