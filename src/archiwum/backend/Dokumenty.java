/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiwum.backend;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author annac
 */
@Entity
@Table(name = "dokumenty")
@NamedQueries({
    @NamedQuery(name = "Dokumenty.findAll", query = "SELECT d FROM Dokumenty d"),
    @NamedQuery(name = "Dokumenty.findById", query = "SELECT d FROM Dokumenty d WHERE d.id = :id"),
    @NamedQuery(name = "Dokumenty.findById_pracownika", query = "SELECT d FROM Dokumenty d WHERE d.idpracownika = :idpracownika"),
    @NamedQuery(name = "Dokumenty.findByRodzaj", query = "SELECT d FROM Dokumenty d WHERE d.rodzaj = :rodzaj"),
    @NamedQuery(name = "Dokumenty.findByNazwa", query = "SELECT d FROM Dokumenty d WHERE d.nazwa = :nazwa")})
public class Dokumenty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "rodzaj")
    private String rodzaj;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @JoinColumn(name = "Id_pracownika", referencedColumnName = "Id_pracownika")
    @ManyToOne
    private Pracownik idpracownika;

    public Dokumenty() {
    }

    public Dokumenty(Integer id, String rodzaj, String nazwa, Pracownik idpracownika) {
        this.id = id;
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
        this.idpracownika = idpracownika;
    }

    public Dokumenty(Integer id) {
        this.id = id;
    }

    public Dokumenty(Integer id, String rodzaj, String nazwa) {
        this.id = id;
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Pracownik getIdpracownika() {
        return idpracownika;
    }

    public void setIdpracownika(Pracownik idpracownika) {
        this.idpracownika = idpracownika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dokumenty)) {
            return false;
        }
        Dokumenty other = (Dokumenty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nazwa: "+nazwa+", kategoria: "+rodzaj;
    }
    
}
