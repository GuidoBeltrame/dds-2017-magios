package ar.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ar.entidades.Empresa;

public class EmpresasRepositorio extends Repositorio{

	public EmpresasRepositorio(EntityManager em) {
		super(em);
	}
	
	public Empresa buscarPorId(Long id) {
		return em.find(Empresa.class, id);
	}
	
	public void persistir(Empresa empresa) {
		em.getTransaction().begin();
		em.persist(empresa);
		em.getTransaction().commit();
	}
	
	public List<Empresa> getEmpresas() {
		Query query = em.createQuery("SELECT e FROM Empresa e");
		return query.getResultList();
	}
	
	public Empresa buscarPorNombre(String nombre) {
		try {
			TypedQuery<Empresa> query = em.createQuery("SELECT e FROM Empresa e WHERE e.nombre = :nombre", Empresa.class);
		
			query.setParameter("nombre", nombre);
			return query.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
}
