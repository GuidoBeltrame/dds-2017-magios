package ar.repositorio;

import javax.persistence.EntityManager;

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
}
