/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Accounts;
import utilities.Data;

/**
 *
 * @author lb38
 */

@Named(value="loginJPABean")
@RequestScoped
public class LoginJPABean implements Serializable{
    private boolean isLoggedIn;
    private boolean isRendered;
    private String userName;
    private String userPW;
    
    @Inject
    private Data dbBean;
     
    // Konstruktor
    public LoginJPABean() {}
    public LoginJPABean(boolean isLoggedIn, boolean isRendered, String userName, String userPW) {
        this.isLoggedIn = isLoggedIn;
        this.isRendered = isRendered;
        this.userName = userName;
        this.userPW = userPW;
    }
   
    // Setter & Getter
    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isIsRendered() {
        return isRendered;
    }
    public void setIsRendered(boolean isRendered) {
        this.isRendered = isRendered;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPW() {
        return userPW;
    }
    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }
    
    // Memberfunktion
    public void showLogin(){
        this.isRendered = true;
    } 

    public String login(){
        if(dbBean.login(userName, userPW)){
            this.setIsRendered(false);
            this.setIsLoggedIn(true);
            logger.info("Login erfolgreich");
            return "kfz.xhtml";
        }
        this.setIsLoggedIn(false);
        logger.info("Login Failed!");
        return "startseite.xhtml";
    }
     
}
