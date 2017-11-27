package ar.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.entidades.IndicadorEmpresa;

public class IndicadorEmpresaRepositorio extends Repositorio {
	
	public IndicadorEmpresaRepositorio(EntityManager em) {
		super(em);
	}

	public void persistir(IndicadorEmpresa indicadorEmpresa) {
		em.getTransaction().begin();
		em.persist(indicadorEmpresa);
		em.getTransaction().commit();
	}
	
	public void update(IndicadorEmpresa indicadorEmpresa) {
		em.getTransaction().begin();
		em.merge(indicadorEmpresa);
		em.getTransaction().commit();
	}
		
	public IndicadorEmpresa buscarIndicador(Long idIndicador, Long idEmpresa, int periodo) {
		try {
			TypedQuery<IndicadorEmpresa> query = em.createQuery("SELECT i FROM IndicadorEmpresa i WHERE i.indicador.idIndicador = :idIndicador " +
					                                            "AND i.empresa.idEmpresa = :idEmpresa " +
								                                "AND i.periodo = :periodo", IndicadorEmpresa.class);
		
			query.setParameter("idIndicador", idIndicador);
			query.setParameter("idEmpresa", idEmpresa);
			query.setParameter("periodo", periodo);

			return query.setMaxResults(1).getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
}
