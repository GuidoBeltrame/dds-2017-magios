package ar.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
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
			//TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :user", Usuario.class);
		
			StoredProcedureQuery query = em.createStoredProcedureQuery("GET_USER", Usuario.class)
				.registerStoredProcedureParameter("user", String.class, ParameterMode.IN)
				.setParameter("user", username);
				 
			query.execute();
				
			//query.setParameter("user", username);
			return (Usuario) query.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
}
