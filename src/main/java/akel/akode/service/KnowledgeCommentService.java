package akel.akode.service;

import akel.akode.model.KnowledgeCommentEntity;
import akel.akode.model.KnowledgeEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

@Stateless
public class KnowledgeCommentService extends AbstractService<KnowledgeCommentEntity> {
    @PersistenceContext(name = "Akode-persistence-unit")
    private EntityManager entityManager;
    @EJB
    private KnowledgeService knowledgeService;

    public KnowledgeCommentService() {
        super(KnowledgeCommentEntity.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void addComment(KnowledgeCommentEntity comment) {
        comment.setCreateAt(new Timestamp(System.currentTimeMillis()));
        create(comment);
        KnowledgeEntity knowledge = comment.getKnowledge();
        knowledgeService.edit(knowledge);
    }
}
