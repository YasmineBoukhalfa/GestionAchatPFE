/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dz.elit.achat.entite.ComptageAe;
import dz.elit.achat.entite.Releve;
import dz.elit.achat.entite.TypeAe;
import dz.elit.achat.service.ReleveFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "calculAchatController")
@ViewScoped
public class CalculAchatController implements Serializable {

    @EJB
    private ReleveFacadeLocal releveFacadeLocal;

    private List<ComptageAe> listCpt;
    private List<TypeAe> listTypeAe;
    private List<Releve> listReleve;

    private String codePdl;
    private Integer comptageAeid;
    private Integer pdlAeid;
    private Integer annee;
    private Integer mois;
    
    @PostConstruct
    public void initialiser(){
        if (Util.getsession("session") == null) {
            try {
                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
                
            }
        }
    }

    private Double brut = 0.0;
    private Double net = 0.0;
    private Double netDist = 0.0;
    private Double perte = 0.0;
    private Double tauxPerte = 0.0;

    public CalculAchatController() {
    }

    public List<TypeAe> getListTypeAe() {
        return listTypeAe;
    }

    public void setListTypeAe(List<TypeAe> listTypeAe) {
        this.listTypeAe = listTypeAe;
    }

    public List<Releve> getListReleve() {
        return listReleve;
    }

    public void setListReleve(List<Releve> listReleve) {
        this.listReleve = listReleve;
    }

    public Double getBrut() {
        return brut;
    }

    public void setBrut(Double brut) {
        this.brut = brut;
    }

    public Double getNet() {
        return net;
    }

    public void setNet(Double net) {
        this.net = net;
    }

    public Double getNetDist() {
        return netDist;
    }

    public void setNetDist(Double netDist) {
        this.netDist = netDist;
    }

    public Double getPerte() {
        return perte;
    }

    public void setPerte(Double perte) {
        this.perte = perte;
    }

    public Double getTauxPerte() {
        return tauxPerte;
    }

    public void setTauxPerte(Double tauxPerte) {
        this.tauxPerte = tauxPerte;
    }

    public List<ComptageAe> getListCpt() {
        return listCpt;
    }

    public void setListCpt(List<ComptageAe> listCpt) {
        this.listCpt = listCpt;
    }

    public String getCodePdl() {
        return codePdl;
    }

    public void setCodePdl(String codePdl) {
        this.codePdl = codePdl;
    }

    public Integer getComptageAeid() {
        return comptageAeid;
    }

    public void setComptageAeid(Integer comptageAeid) {
        this.comptageAeid = comptageAeid;
    }

    public Integer getPdlAeid() {
        return pdlAeid;
    }

    public void setPdlAeid(Integer pdlAeid) {
        this.pdlAeid = pdlAeid;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    /*
     *************Méthodes************
     */
    //Calculer les quantités d'achats et les pertes d'énergie
    public void calculAchat() {
        brut = releveFacadeLocal.findSomByAnneeMois("XEH", getAnnee(), getMois())
                + releveFacadeLocal.findSomByAnneeMois("XEP", getAnnee(), getMois())
                + releveFacadeLocal.findSomByAnneeMois("XET", getAnnee(), getMois())
                + releveFacadeLocal.findSomByAnneeMois("XEC", getAnnee(), getMois());
        setBrut(brut);

        net = brut + releveFacadeLocal.findSomByAnneeMois("XEER", getAnnee(), getMois())
                + releveFacadeLocal.findSomByAnneeMois("XEEE", getAnnee(), getMois());
        setNet(net);

        netDist = net - releveFacadeLocal.findSomByAnneeMois("XEC", getAnnee(), getMois());
        setNetDist(netDist);

        perte = netDist - releveFacadeLocal.findSomByAnneeMois("XEP", getAnnee(), getMois());
        setPerte(perte);

        tauxPerte = (perte / netDist) * 100;
        setTauxPerte(tauxPerte);
    }

}
