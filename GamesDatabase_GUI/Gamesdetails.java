/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesdatabase;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author blade
 */
@Entity
@Table(name = "GAMESDETAILS", catalog = "", schema = "USER1")
@NamedQueries({
    @NamedQuery(name = "Gamesdetails.findAll", query = "SELECT g FROM Gamesdetails g")
    , @NamedQuery(name = "Gamesdetails.findByGametitle", query = "SELECT g FROM Gamesdetails g WHERE g.gametitle = :gametitle")
    , @NamedQuery(name = "Gamesdetails.findByGamegenre", query = "SELECT g FROM Gamesdetails g WHERE g.gamegenre = :gamegenre")
    , @NamedQuery(name = "Gamesdetails.findByGamedeveloper", query = "SELECT g FROM Gamesdetails g WHERE g.gamedeveloper = :gamedeveloper")
    , @NamedQuery(name = "Gamesdetails.findByGamerelease", query = "SELECT g FROM Gamesdetails g WHERE g.gamerelease = :gamerelease")
    , @NamedQuery(name = "Gamesdetails.findByGamepriceineuro", query = "SELECT g FROM Gamesdetails g WHERE g.gamepriceineuro = :gamepriceineuro")
    , @NamedQuery(name = "Gamesdetails.findByGameoftheyear", query = "SELECT g FROM Gamesdetails g WHERE g.gameoftheyear = :gameoftheyear")
    , @NamedQuery(name = "Gamesdetails.findByGameconsolerelease", query = "SELECT g FROM Gamesdetails g WHERE g.gameconsolerelease = :gameconsolerelease")
    , @NamedQuery(name = "Gamesdetails.findByGamerating", query = "SELECT g FROM Gamesdetails g WHERE g.gamerating = :gamerating")})
public class Gamesdetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GAMETITLE")
    private String gametitle;
    @Column(name = "GAMEGENRE")
    private String gamegenre;
    @Column(name = "GAMEDEVELOPER")
    private String gamedeveloper;
    @Column(name = "GAMERELEASE")
    private Integer gamerelease;
    @Column(name = "GAMEPRICEINEURO")
    private Integer gamepriceineuro;
    @Column(name = "GAMEOFTHEYEAR")
    private Boolean gameoftheyear;
    @Column(name = "GAMECONSOLERELEASE")
    private String gameconsolerelease;
    @Column(name = "GAMERATING")
    private Integer gamerating;

    public Gamesdetails() {
    }

    public Gamesdetails(String gametitle) {
        this.gametitle = gametitle;
    }

    public String getGametitle() {
        return gametitle;
    }

    public void setGametitle(String gametitle) {
        String oldGametitle = this.gametitle;
        this.gametitle = gametitle;
        changeSupport.firePropertyChange("gametitle", oldGametitle, gametitle);
    }

    public String getGamegenre() {
        return gamegenre;
    }

    public void setGamegenre(String gamegenre) {
        String oldGamegenre = this.gamegenre;
        this.gamegenre = gamegenre;
        changeSupport.firePropertyChange("gamegenre", oldGamegenre, gamegenre);
    }

    public String getGamedeveloper() {
        return gamedeveloper;
    }

    public void setGamedeveloper(String gamedeveloper) {
        String oldGamedeveloper = this.gamedeveloper;
        this.gamedeveloper = gamedeveloper;
        changeSupport.firePropertyChange("gamedeveloper", oldGamedeveloper, gamedeveloper);
    }

    public Integer getGamerelease() {
        return gamerelease;
    }

    public void setGamerelease(Integer gamerelease) {
        Integer oldGamerelease = this.gamerelease;
        this.gamerelease = gamerelease;
        changeSupport.firePropertyChange("gamerelease", oldGamerelease, gamerelease);
    }

    public Integer getGamepriceineuro() {
        return gamepriceineuro;
    }

    public void setGamepriceineuro(Integer gamepriceineuro) {
        Integer oldGamepriceineuro = this.gamepriceineuro;
        this.gamepriceineuro = gamepriceineuro;
        changeSupport.firePropertyChange("gamepriceineuro", oldGamepriceineuro, gamepriceineuro);
    }

    public Boolean getGameoftheyear() {
        return gameoftheyear;
    }

    public void setGameoftheyear(Boolean gameoftheyear) {
        Boolean oldGameoftheyear = this.gameoftheyear;
        this.gameoftheyear = gameoftheyear;
        changeSupport.firePropertyChange("gameoftheyear", oldGameoftheyear, gameoftheyear);
    }

    public String getGameconsolerelease() {
        return gameconsolerelease;
    }

    public void setGameconsolerelease(String gameconsolerelease) {
        String oldGameconsolerelease = this.gameconsolerelease;
        this.gameconsolerelease = gameconsolerelease;
        changeSupport.firePropertyChange("gameconsolerelease", oldGameconsolerelease, gameconsolerelease);
    }

    public Integer getGamerating() {
        return gamerating;
    }

    public void setGamerating(Integer gamerating) {
        Integer oldGamerating = this.gamerating;
        this.gamerating = gamerating;
        changeSupport.firePropertyChange("gamerating", oldGamerating, gamerating);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gametitle != null ? gametitle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gamesdetails)) {
            return false;
        }
        Gamesdetails other = (Gamesdetails) object;
        if ((this.gametitle == null && other.gametitle != null) || (this.gametitle != null && !this.gametitle.equals(other.gametitle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Gamesdetails[ gametitle=" + gametitle + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}