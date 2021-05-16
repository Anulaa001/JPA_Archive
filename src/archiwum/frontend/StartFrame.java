/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiwum.frontend;

import archiwum.Main;
import archiwum.backend.BazaDanych;
import archiwum.backend.Dokumenty;
import archiwum.backend.Pracownik;
import java.awt.Toolkit;
import java.util.List;

/**
 *
 * @author annac
 */
public class StartFrame extends javax.swing.JFrame {

    /**
     * Creates new form StartFrame
     */
    public StartFrame() {
        initComponents();
        db = new BazaDanych();
        p = new Pracownik();
        d = new Dokumenty();
        counter = 0;
        listaPracownikow = db.pracownicy();
        wyswietlDokumenty(counter);
        bPoporzedni.setEnabled(false);
        
        
    }

    private void wyswietlDokumenty(int counter){	      
         this.p = listaPracownikow.get(counter);
         tPracownik.setText(String.valueOf(p.getIdpracownika())+". "+p.getImie()+" "+p.getNazwisko());
         listaDokumentow = db.dokumenty_idPracownika(p);
         for(int i=0;i<listaDokumentow.size();i++)
           tDokumenty.append(String.valueOf(listaDokumentow.get(i)+"\n"));
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tPracownik = new javax.swing.JTextField();
        bNastepny = new javax.swing.JButton();
        bPoporzedni = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDokumenty = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mPDF = new javax.swing.JMenuItem();
        mZakoncz = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mEdytujPracownika = new javax.swing.JMenuItem();
        mEdytujDokument = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mDodajPracownika = new javax.swing.JMenuItem();
        mDodajDokument = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Archiwum osobowe");

        tPracownik.setEditable(false);
        tPracownik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPracownikActionPerformed(evt);
            }
        });

        bNastepny.setText(">");
        bNastepny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNastepnyActionPerformed(evt);
            }
        });

        bPoporzedni.setText("<");
        bPoporzedni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPoporzedniActionPerformed(evt);
            }
        });

        jLabel2.setText("Pracownik");

        jLabel3.setText("Posiadane dokumenty");

        tDokumenty.setEditable(false);
        tDokumenty.setBackground(new java.awt.Color(240, 240, 240));
        tDokumenty.setColumns(20);
        tDokumenty.setRows(5);
        jScrollPane1.setViewportView(tDokumenty);

        jMenu1.setText("Plik");

        mPDF.setText("Pobierz PDF");
        mPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPDFActionPerformed(evt);
            }
        });
        jMenu1.add(mPDF);

        mZakoncz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        mZakoncz.setText("Zakończ");
        mZakoncz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mZakonczActionPerformed(evt);
            }
        });
        jMenu1.add(mZakoncz);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edycja");

        mEdytujPracownika.setText("Edytuj pracownika");
        mEdytujPracownika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEdytujPracownikaActionPerformed(evt);
            }
        });
        jMenu2.add(mEdytujPracownika);

        mEdytujDokument.setText("Edytuj dokument");
        mEdytujDokument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEdytujDokumentActionPerformed(evt);
            }
        });
        jMenu2.add(mEdytujDokument);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Dodawanie");

        mDodajPracownika.setText("Dodaj pracownika");
        mDodajPracownika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDodajPracownikaActionPerformed(evt);
            }
        });
        jMenu3.add(mDodajPracownika);

        mDodajDokument.setText("Dodaj dokument");
        mDodajDokument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDodajDokumentActionPerformed(evt);
            }
        });
        jMenu3.add(mDodajDokument);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bPoporzedni)
                        .addGap(31, 31, 31)
                        .addComponent(bNastepny)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tPracownik, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addGap(0, 107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPracownik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPoporzedni)
                    .addComponent(bNastepny))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tPracownikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPracownikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPracownikActionPerformed

    private void bPoporzedniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPoporzedniActionPerformed
        // TODO add your handling code here:
        if(counter>0){
            counter-=1;
            tDokumenty.setText("");
            this.wyswietlDokumenty(counter);
            if(counter==0) bPoporzedni.setEnabled(false);
            bNastepny.setEnabled(true);
        }
    }//GEN-LAST:event_bPoporzedniActionPerformed

    private void bNastepnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNastepnyActionPerformed
        // TODO add your handling code here:
        if(counter+1<listaPracownikow.size()){
            counter+=1;
            tDokumenty.setText("");
            this.wyswietlDokumenty(counter);
            if(counter==listaPracownikow.size()-1) bNastepny.setEnabled(false);
            bPoporzedni.setEnabled(true);
        }
    }//GEN-LAST:event_bNastepnyActionPerformed

    private void mZakonczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mZakonczActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mZakonczActionPerformed

    private void mDodajPracownikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDodajPracownikaActionPerformed
        // TODO add your handling code here:
        dpf = new DodajPracownikaFrame();
        dpf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Uni\\Prace domowe\\sem 4\\apki bazy\\archive.png"));
        dpf. setSize(460,400);
        dpf.setTitle("Dodaj pracownika");
        dpf.setVisible(true);
    }//GEN-LAST:event_mDodajPracownikaActionPerformed

    private void mDodajDokumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDodajDokumentActionPerformed
        // TODO add your handling code here:
        ddf = new DodajDokumentFrame();
        ddf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Uni\\Prace domowe\\sem 4\\apki bazy\\archive.png"));
        ddf. setSize(460,400);
        ddf.setTitle("Dodaj dokument");
        ddf.setVisible(true);
    }//GEN-LAST:event_mDodajDokumentActionPerformed

    private void mEdytujPracownikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEdytujPracownikaActionPerformed
        // TODO add your handling code here:
        epf = new EdytujPracownikFrame();
        epf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Uni\\Prace domowe\\sem 4\\apki bazy\\archive.png"));
        epf. setSize(460,400);
        epf.setTitle("Edytuj pracownika");
        epf.setVisible(true);
    }//GEN-LAST:event_mEdytujPracownikaActionPerformed

    private void mEdytujDokumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEdytujDokumentActionPerformed
        // TODO add your handling code here:
        edf = new EdytujDokumentFrame();
        edf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Uni\\Prace domowe\\sem 4\\apki bazy\\archive.png"));
        edf. setSize(460,400);
        edf.setTitle("Edytuj dokument");
        edf.setVisible(true);
                             
    }//GEN-LAST:event_mEdytujDokumentActionPerformed

    private void mPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPDFActionPerformed
        // TODO add your handling code here:
        db.pobierzPDF();
    }//GEN-LAST:event_mPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNastepny;
    private javax.swing.JButton bPoporzedni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mDodajDokument;
    private javax.swing.JMenuItem mDodajPracownika;
    private javax.swing.JMenuItem mEdytujDokument;
    private javax.swing.JMenuItem mEdytujPracownika;
    private javax.swing.JMenuItem mPDF;
    private javax.swing.JMenuItem mZakoncz;
    private javax.swing.JTextArea tDokumenty;
    private javax.swing.JTextField tPracownik;
    // End of variables declaration//GEN-END:variables
    private BazaDanych db;
    private Pracownik p;
    private Dokumenty d;
    List<Pracownik> listaPracownikow;
    int counter;
    List<Dokumenty> listaDokumentow;
    private DodajPracownikaFrame dpf;
    private DodajDokumentFrame ddf;
    private EdytujPracownikFrame epf;
    private EdytujDokumentFrame edf;

}