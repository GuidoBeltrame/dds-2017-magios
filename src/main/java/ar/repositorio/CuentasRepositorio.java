package ar.repositorio;

import javax.persistence.EntityManager;
import ar.entidades.Cuenta;

public class CuentasRepositorio extends Repositorio{

	public CuentasRepositorio(EntityManager em) {
		super(em);
	}
	
	public Cuenta buscarPorId(Long id) {
		return em.find(Cuenta.class, id);
	}
	
	public void persistir(Cuenta cuenta) {
		em.getTransaction().begin();
		em.persist(cuenta);
		em.getTransaction().commit();
	}
}
