/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yacine-PC
 */
public class Util extends HttpServlet {

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
//        ExternalContext fs = FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        HttpSession session = (HttpSession) fs.getSession(false);
//        session.removeAttribute(type);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public static void redirectTo(String page) throws IOException {
        FacesContext fs = FacesContext.getCurrentInstance();
        fs.getExternalContext().redirect(page);
    }

    
    static String base_url() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
