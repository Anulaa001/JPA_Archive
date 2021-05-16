/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiwum.backend;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author annac
 */
public class BazaDanych {
    public BazaDanych(){
       
    }
    public void zapisz(Pracownik pracownik){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("archiwumPU");
        
        //utworzenie obiektu entitymanager
        EntityManager em = emf.createEntityManager();
        //rozpoczecie transakcji
        em.getTransaction().begin();
        //zapisanie obiektu z bazie metoda persist()
        try{
            em.persist(pracownik);
            //zatwierdzenie transakcji
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Zapisano");
        }
        finally{
            //zamkniecie transakcji
            em.close();
        }
        
    }
    public void zapiszDoc(Dokumenty dokumenty){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("archiwumPU");
        
        //utworzenie obiektu entitymanager
        EntityManager em = emf.createEntityManager();
        //rozpoczecie transakcji
        em.getTransaction().begin();
        //zapisanie obiektu z bazie metoda persist()
        try{
            em.persist(dokumenty);
            //zatwierdzenie transakcji
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Zapisano");
        }
        finally{
            //zamkniecie transakcji
            em.close();
        }
        
    }
    public void edytuj(Integer idpracownika, String imie, String nazwisko, String pesel){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("archiwumPU");
        
        //utworzenie obiektu entitymanager
        EntityManager em = emf.createEntityManager();
        //rozpoczecie transakcji
        Pracownik p = em.find(Pracownik.class, idpracownika);
        p.setImie(imie);
        p.setNazwisko(nazwisko);
        p.setPesel(pesel);
        em.getTransaction().begin();
        //zapisanie obiektu z bazie metoda persist()
        
        try{
            
            em.persist(p);
            //zatwierdzenie transakcji
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Zapisano");
        }
        finally{
            //zamkniecie transakcji
            em.close();
        }
        
    }
    public void edytujDoc(Integer id, String rodzaj, String nazwa, Pracownik p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("archiwumPU");
        
        //utworzenie obiektu entitymanager
        EntityManager em = emf.createEntityManager();
        //rozpoczecie transakcji
        Dokumenty d = em.find(Dokumenty.class, id);
        d.setRodzaj(rodzaj);
        d.setNazwa(nazwa);
        
        em.getTransaction().begin();
        //zapisanie obiektu z bazie metoda persist()
        
        try{
            
            em.persist(d);
            //zatwierdzenie transakcji
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Zapisano");
        }
        finally{
            //zamkniecie transakcji
            em.close();
        }
        
    }
    EntityManagerFactory emf;
    public EntityManager getEntityManager(){
        if(emf==null) emf=Persistence.createEntityManagerFactory("archiwumPU");
        return emf.createEntityManager();
    }
    public List<Pracownik> pracownicy(){
         EntityManager em = this.getEntityManager();
         TypedQuery<Pracownik> q = em.createNamedQuery("Pracownik.findAll", Pracownik.class);
         return q.getResultList();
    }
    
    public List<Dokumenty> dokumenty(){
         EntityManager em = this.getEntityManager();
         TypedQuery<Dokumenty> q = em.createNamedQuery("Dokumenty.findAll", Dokumenty.class);
         return q.getResultList();
    }
    public List<Dokumenty> dokumenty_idPracownika(Pracownik Id_pracownika){
         EntityManager em = this.getEntityManager();
         TypedQuery<Dokumenty> q = em.createNamedQuery("Dokumenty.findById_pracownika", Dokumenty.class);
         q.setParameter("idpracownika", Id_pracownika);
         return q.getResultList();
    }
    public void pobierzPDF(){
        try{
            String file="D:\\Uni\\Prace domowe\\sem 4\\apki bazy\\archiwum.pdf";
            Document dokument = new Document();   
            PdfWriter.getInstance(dokument, new FileOutputStream(file));
            dokument.open();
            Paragraph Tytul = new Paragraph("Archiwum osobowe");
            Tytul.setAlignment(Element.ALIGN_CENTER);
            Tytul.setSpacingAfter(50);
            dokument.add(Tytul);
            dokument.add(new Paragraph(""));

            List<Pracownik> listapracownikow = pracownicy();
            for(int i =0; i<listapracownikow.size();i++){
                Pracownik p = listapracownikow.get(i);
                 Paragraph para = new Paragraph(p.toString());
                 dokument.add(para);
                 dokument.add(new Paragraph(""));
                List<Dokumenty> listadokumetow = dokumenty_idPracownika(p);
                for(int j = 0; j<listadokumetow.size();j++){
                    Dokumenty d = listadokumetow.get(j);
                    Paragraph paraD = new Paragraph(d.toString());
                    dokument.add(paraD);
                    dokument.add(new Paragraph(""));
                    
                }
                
            }
            dokument.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Błąd aplikacji", 
                    JOptionPane.ERROR_MESSAGE);        
        }
    }
}
