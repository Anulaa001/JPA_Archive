/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiwum.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author annac
 */
@Entity
@Table(name = "pracownik")
@NamedQueries({
    @NamedQuery(name = "Pracownik.findAll", query = "SELECT p FROM Pracownik p"),
    @NamedQuery(name = "Pracownik.findByIdpracownika", query = "SELECT p FROM Pracownik p WHERE p.idpracownika = :idpracownika"),
    @NamedQuery(name = "Pracownik.findByImie", query = "SELECT p FROM Pracownik p WHERE p.imie = :imie"),
    @NamedQuery(name = "Pracownik.findByNazwisko", query = "SELECT p FROM Pracownik p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "Pracownik.findByPesel", query = "SELECT p FROM Pracownik p WHERE p.pesel = :pesel")})
public class Pracownik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_pracownika")
    private Integer idpracownika;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "pesel")
    private String pesel;
    @OneToMany(mappedBy = "idpracownika")
    private Collection<Dokumenty> dokumentyCollection = new ArrayList<Dokumenty>();

    public Pracownik() {
    }
    public Pracownik(Integer idpracownika, String imie, String nazwisko, String pesel) {
        this.idpracownika = idpracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }
    public Pracownik(Integer idpracownika) {
        this.idpracownika = idpracownika;
    }
    public Integer getIdpracownika() {
        return idpracownika;
    }

    public void setIdpracownika(Integer idpracownika) {
        this.idpracownika = idpracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Collection<Dokumenty> getDokumentyCollection() {
        return dokumentyCollection;
    }

    public void setDokumentyCollection(Collection<Dokumenty> dokumentyCollection) {
        this.dokumentyCollection = dokumentyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpracownika != null ? idpracownika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pracownik)) {
            return false;
        }
        Pracownik other = (Pracownik) object;
        if ((this.idpracownika == null && other.idpracownika != null) || (this.idpracownika != null && !this.idpracownika.equals(other.idpracownika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idpracownika + ". "+imie+" "+nazwisko;
    }
    
}
