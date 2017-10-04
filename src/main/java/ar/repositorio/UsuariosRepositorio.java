package ar.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ar.entidades.Usuario;


public class UsuariosRepositorio extends Repositorio {
	
	public UsuariosRepositorio(EntityManager em) {
		super(em);
	}
	
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public void persistir(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuarioPorUsername(String username) {
	
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :user", Usuario.class);
		
			query.setParameter("user", username);
			return query.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
}
