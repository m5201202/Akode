package akel.akode.bean;

import akel.akode.model.KnowledgeCommentEntity;
import akel.akode.model.KnowledgeEntity;
import akel.akode.service.KnowledgeCommentService;
import akel.akode.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class KnowledgeShowBean implements Serializable {
    private Long id;
    private KnowledgeEntity knowledge;
    private KnowledgeCommentEntity knowledgeComment;
    @EJB
    private KnowledgeService knowledgeService;
    @EJB
    private KnowledgeCommentService knowledgeCommentService;

    public void show() {
        knowledge = knowledgeService.findById(id);
        knowledgeComment = new KnowledgeCommentEntity();
    }

    public void addComment() {
        getKnowledgeComment().setKnowledge(knowledge);
        knowledgeCommentService.addComment(getKnowledgeComment());
        show();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KnowledgeEntity getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(KnowledgeEntity knowledge) {
        this.knowledge = knowledge;
    }

    public KnowledgeCommentEntity getKnowledgeComment() {
        return knowledgeComment;
    }

    public void setKnowledgeComment(KnowledgeCommentEntity knowledgeComment) {
        this.knowledgeComment = knowledgeComment;
    }
}
