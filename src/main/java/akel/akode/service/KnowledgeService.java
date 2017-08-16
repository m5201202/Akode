package akel.akode.service;

import akel.akode.model.KnowledgeEntity;
import akel.akode.model.KnowledgeEntity_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class KnowledgeService extends AbstractService<KnowledgeEntity> {

    @PersistenceContext(name = "Akode-persistence-unit")
    private EntityManager entityManager;

    public KnowledgeService() {
        super(KnowledgeEntity.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public KnowledgeEntity findById(Long id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<KnowledgeEntity> cq = cb.createQuery(KnowledgeEntity.class);
        Root<KnowledgeEntity> model = cq.from(KnowledgeEntity.class);
        cq.where(cb.equal(model.get(KnowledgeEntity_.id), id));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
