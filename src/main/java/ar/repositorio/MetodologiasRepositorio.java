package ar.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.entidades.Metodologia;

public class MetodologiasRepositorio extends Repositorio {

	public MetodologiasRepositorio(EntityManager em) {
		super(em);
	}
	
	public Metodologia buscarPorId(Long id) {
		return em.find(Metodologia.class, id);
	}
	
	public void persistir(Metodologia metodologia) {
		em.getTransaction().begin();
		em.persist(metodologia);
		em.getTransaction().commit();
	}
	
	public List<Metodologia> getMetodologias() {
		Query query = em.createQuery("SELECT m FROM Metodologia m");
		return query.getResultList();
	}
}
