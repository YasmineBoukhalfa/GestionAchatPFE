/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dz.elit.achat.entite.Utilisateur;
import dz.elit.achat.service.UtilisateurFacadeLocal;
import dz.elit.achat.session.UtilisateurFacade;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ihab Boudissa
 */
@ManagedBean(name = "utilisateurController")
@ViewScoped
public class UtilisateurController implements Serializable {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacadeLocal;
    private UtilisateurFacade utilisateurFacade;

    private Utilisateur user;
    private String nom;
    private String mdp;
    private String message;

    public UtilisateurController() {
    }

    @PostConstruct
    public void initialiserReleve() {
        user = new Utilisateur();
        nom = null;
        mdp = null;
    }

    public UtilisateurFacadeLocal getUtilisateurFacadeLocal() {
        return utilisateurFacadeLocal;
    }

    public void setUtilisateurFacadeLocal(UtilisateurFacadeLocal utilisateurFacadeLocal) {
        this.utilisateurFacadeLocal = utilisateurFacadeLocal;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Utilisateur getSelected() {
        if (user == null) {
            user = new Utilisateur();
        }
        return user;
    }

    public UtilisateurFacade getFacade() {
        return utilisateurFacade;
    }

    public void initialiserUser() {
        user = new Utilisateur();
        this.nom = null;
        this.mdp = null;
    }

    public String valider(String nom, String mdp) {
        Utilisateur utilisateurTrouve = null;

        utilisateurTrouve = utilisateurFacadeLocal.findByUser(getNom(), getMdp());

        if (utilisateurTrouve == null) {
            return "/releve/Login.xhtml";
        } else {
            Util.setsession("session", "sessionValue");
            return "/releve/welcomePage.xhtml";
        }

    }

    public String getMessage() {
        return message;
    }

    public static String getsession(String sessionName) {
        ExternalContext fs = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) fs.getSession(false);
        return (String) session.getAttribute(sessionName);
    }

    public static void setsession(String sessionName, String sessionValue) {
        FacesContext fs = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fs.getExternalContext().getSession(true);
        session.setAttribute(sessionName, sessionValue);
    }

    public static void destroysession(String type) {
        ExternalContext fs = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) fs.getSession(false);
        session.removeAttribute(type);
    }

    public static void redirectTo(String page) throws IOException {
        FacesContext fs = FacesContext.getCurrentInstance();
        fs.getExternalContext().redirect(page);

    }

    public void destroy() {
        destroysession("session");

        try {
            redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
        } catch (IOException ex) {
            System.out.println("impossible de deco");
        }
    }

    static String base_url() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
