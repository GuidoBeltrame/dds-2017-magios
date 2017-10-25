package ar.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	public List<Cuenta> getCuentas() {
		Query query = em.createQuery("SELECT c FROM Cuenta c");
		return query.getResultList();
	}
	
	public Cuenta buscarPorNombre(String nombre) {
		try {
			TypedQuery<Cuenta> query = em.createQuery("SELECT c FROM Cuenta c WHERE c.nombre = :nombre", Cuenta.class);
		
			query.setParameter("nombre", nombre);
			return query.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public double obtenerValorCuenta(String identificadorCuenta, Long codEmpresa, int periodo) {
		try {
			TypedQuery<Double> query = em.createQuery("SELECT b.valor FROM balance b, cuenta c "
					+ "WHERE b.idCuenta = c.idCuenta "
					+ "AND c.identificador = :identificadorCuenta "
					+ "AND b.idEmpresa = :codEmpresa", double.class);
		
			query.setParameter("identificadorCuenta", identificadorCuenta);
			query.setParameter("codEmpresa", codEmpresa);
			
			return query.getSingleResult();
		}
		catch (Exception ex) {
			return 0;
		}
	}
}
