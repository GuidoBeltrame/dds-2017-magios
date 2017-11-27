package ar.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.entidades.Proceso;

public class ProcesosRepositorio extends Repositorio {

	public ProcesosRepositorio(EntityManager em) {
		super(em);
	}
	
	public void persistir(Proceso proceso) {
		em.getTransaction().begin();
		em.persist(proceso);
		em.getTransaction().commit();
	}
	
	public Proceso buscarPorNombre(String nombreArchivo) {
		try {
			TypedQuery<Proceso> query = em.createQuery("SELECT p FROM Proceso p WHERE p.nombreArchivo = :nombreArchivo", Proceso.class);
		
			query.setParameter("nombreArchivo", nombreArchivo);
			return query.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
}
