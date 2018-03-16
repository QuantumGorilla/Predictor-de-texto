package predictor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Alejo
 */
public class Predictor extends javax.swing.JFrame {

    String[] palabras;
    DefaultListModel listModel;

    public Predictor() {
        initComponents();
        init();
    }

    private void init() {
        setLocationRelativeTo(null);
        leerVocabulario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Predictor de texto");

        jScrollPane2.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Sugerencias:");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        if (evt.getKeyCode() == 32 || evt.getKeyCode() == 16 || evt.getKeyCode() == 127) {
        } else if ((evt.getKeyCode() > 64 && evt.getKeyCode() < 91) || (evt.getKeyCode() > 96 && evt.getKeyCode() < 123) || (evt.getKeyCode() == 8)) {
            String[] sugerencias = buscarSugerencias(ultimaPalabra());
            añadirItems(sugerencias);
        }
    }//GEN-LAST:event_jTextArea1KeyReleased
    private String[] buscarSugerencias(String palabra) {
        System.out.println(palabra);
        String[] sugerencias = new String[palabras.length];
        int cont = 0;
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() >= palabra.length()) {
                if (palabras[i].substring(0, palabra.length()).equalsIgnoreCase(palabra)) {
                    sugerencias[cont] = palabras[i];
                    cont++;
                }
            }
        }
        return sugerencias;
    }

    private void añadirItems(String[] items) {
        listModel = new DefaultListModel();
        for (int i = 0; i < items.length; i++) {
            listModel.addElement(items[i]);
        }
        jList1.setModel(listModel);
    }

    private String ultimaPalabra() {
        String[] palabrasTexto = jTextArea1.getText().split(" ");
        return palabrasTexto[jTextArea1.getText().split(" ").length - 1];
    }

    private void comentario() {
        /*static void CrearArchivo() throws IOException {
        String ruta = "C:/apps/vocabulario.txt";
        File vocabulario = new File(ruta);
        BufferedWriter bw;
        if (vocabulario.exists()) {
            bw = new BufferedWriter(new FileWriter(vocabulario));
            bw.write("El archivo de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(vocabulario));
            bw.write("Abordar, Abrumar, Abstenerse, Acápite, Acatar, Accesorio, Acicalarse, Acopio, Acoso, \n"
                    + "Acotación, Acrecienta, Acróstico, Acta, Actitud, Bambolearse, Bastante, Beluga, \n"
                    + "Bifurcación, Biografía, Bitácora, Bocanada, Borda, Bosquejo, Brahmán, Brainstorm, \n"
                    + "Bronca, Burladero, Butaca, Caldear, Calidad total, Candente, Camaleón, Caos, \n"
                    + "Capciosas, Capitalizar, Capo di capi, Característica, Carisma, Denostar, \n"
                    + "Denotando, Derecho, Desabrido, Desliz, Destaca, Detractores, Dexteridad,\n"
                    + "Diapositiva, Efecto, Eficaz, Eficiente, Egocentrista,Egoísta, Egolatría, Ejecutivo,\n"
                    + "Factor, Falacia, Falta de tacto, Familia, Fanfarrón, Fe,Habla, Heces, Hedonista, \n"
                    + "Heurístico, Hipersensibilidad, Hipnotizador, Idiosincrasia, Idóneo, Ilusión,\n"
                    + "Ilustración, Ilustrar, Impecable, Impertérrito, Impertinente, Implantar, Implosión,\n"
                    + "Jerarquía, John, Jubilación, Karate, Kinestésico, Know how, Latente, Laudable, \n"
                    + "Legítimo, Libreto, Lidiar, Limadura de hierro, Maquiavélico, Marketing, Masoquismo,\n"
                    + "Mayéutica, Mediático, Mediocre, Menoscabar, Mente maestra, Metafísico, Metafórico,\n"
                    + "Nanómetro, NASA, Nefasto, Nemotecnia, Nequáquam, Nimio, Objeción, Objetivo, \n"
                    + "Obnubilar, Obvio, Oclusivo, Oír, Patente, Patético, Pausa, Pauta, Pecado, \n"
                    + "Pedante, Péndulo, Penetrantes, Pericia, Perorata, Quid, Quid pro quo, \n"
                    + "Radio, Rangos, Reacio, Recargarse, Reconciliación, Referencia,Reflexión,\n"
                    + "Refranes, Refutar, Reglamento, Sabiduría, Sadismo, Sánscrito, Savoir-faire,\n"
                    + "Secoya, Secuencia, Seminario, Táctica, Técnica, Teleológico, Tema, Tener, Traducir,\n"
                    + "Urbanidad, URL, Utópico, Valor añadido, Valores, Verbal, Verborrea, Verificando, \n"
                    + "Versátil, Viceversa, Vídeo, Vigorosamente, Web, Webmaster, Yen, Yuan");
        }
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String linea;
        String Palabras[] = vocabulario.list();
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

        br.close();
    }*/
    }

    private void leerVocabulario() {
        FileReader fr = null;
        try {
            fr = new FileReader(new File("vocabulario.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("vocabulario.txt")), "ISO-8859-1"));
            String lineas[] = br.readLine().split(",");
            palabras = new String[lineas.length];
            palabras = lineas;
        } catch (IOException ex) {
            Logger.getLogger(Predictor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(Predictor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Predictor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Predictor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Predictor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new Predictor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
