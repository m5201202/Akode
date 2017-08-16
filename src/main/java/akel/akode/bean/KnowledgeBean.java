package akel.akode.bean;

import akel.akode.model.KnowledgeEntity;
import akel.akode.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class KnowledgeBean implements Serializable {
    @EJB
    private KnowledgeService knowledgeService;

    public List<KnowledgeEntity> getKnowledgeList() {
        return knowledgeService.findAll();
    }
}
