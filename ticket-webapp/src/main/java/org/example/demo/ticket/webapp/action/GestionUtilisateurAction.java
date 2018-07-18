package org.example.demo.ticket.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.webapp.WebappHelper;

/**
 * Created by esspressoh on 09.07.18.
 */
public class GestionUtilisateurAction extends ActionSupport {

    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie

    private Utilisateur utilisateur;



    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // ==================== Méthodes ====================


    /**
     * Action affichant les détails d'un {@link Projet}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de projet");
        } else {
            try {
                utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError("Projet non trouvé. ID = " + id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }


}
