/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiwum;

import archiwum.frontend.StartFrame;
import java.awt.Toolkit;


/**
 *
 * @author annac
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        //Pracownik pr = new Pracownik(1,"Krystyna","Kapus","1234567890");
        //Dokumenty doc = new Dokumenty(1,"A","CV",pr);
       //Main m = new Main();
       //m.zapiszDoc(doc);
       
       //List<Dokumenty> listaStudentowImieNazwisko=m.dokumenty_idPracownika(pr);
       //for(int i=0;i<listaStudentowImieNazwisko.size();i++)
           //System.out.println(listaStudentowImieNazwisko.get(i));
           
           
        StartFrame sf = new StartFrame();
        sf. setSize(500,440);
        sf.setTitle("Archiwum osobowe");
        sf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Uni\\Prace domowe\\sem 4\\apki bazy\\archive.png"));
        sf.setVisible(true);
    }
    
}
