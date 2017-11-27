package ar.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	public int buscarBalance(Long idCuenta, Long idEmpresa, int periodo) {
		try {
			TypedQuery<Integer> query = em.createQuery("SELECT 1 FROM Balance b WHERE b.cuenta.idCuenta = :idCuenta " +
		                                               "AND b.empresa.idEmpresa = :idEmpresa " +
					                                   "AND b.periodo = :periodo", Integer.class);
		
			query.setParameter("idCuenta", idCuenta);
			query.setParameter("idEmpresa", idEmpresa);
			query.setParameter("periodo", periodo);

			return query.setMaxResults(1).getSingleResult();
		}
		catch (Exception ex) {
			return 0;
		}
	}
}
