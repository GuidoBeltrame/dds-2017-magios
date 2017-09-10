package ar.repositorio;

import javax.persistence.EntityManager;

import ar.entidades.Balance;

public class BalancesRepositorio extends Repositorio {
	public BalancesRepositorio(EntityManager em) {
		super(em);
	}
	
	public Balance buscarPorId(Long id) {
		return em.find(Balance.class, id);
	}
	
	public void persistir(Balance balance) {
		em.getTransaction().begin();
		em.persist(balance);
		em.getTransaction().commit();
	}

}
