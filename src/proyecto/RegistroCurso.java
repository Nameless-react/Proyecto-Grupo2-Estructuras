/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import javax.swing.JFrame;
import proyecto.Estructuras.ListaSimpleCursos;


/**
 *
 * @author joel
 */
public class RegistroCurso extends javax.swing.JFrame {
    public static ListaSimpleCursos cursos = new ListaSimpleCursos();
    /**
     * Creates new form RegistroHorario
     */
    public RegistroCurso() {
        initComponents();
        setTitle("Formulario Cursos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        for (Horario schedule : RegistroHorario.schedules.fillComboBox()) {
            if (schedule == null) continue;
            cmb.addItem(schedule.toString());
        }
        
    }
    
    public void clear() {
        txtf1.setText("");
        txtf2.setText("");
        txtf3.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtf2 = new javax.swing.JTextField();
        txtf1 = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();
        txtNombre1 = new javax.swing.JLabel();
        cmb = new javax.swing.JComboBox<>();
        txtNombre2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtf3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAtras.setText("<<Atrás");
        botonAtras.setBorder(null);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Registro de Cursos");

        txtNombre.setText("Codigo:");

        txtf2.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));

        txtf1.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));

        botonAgregar.setBackground(new java.awt.Color(102, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 0, 0));
        botonAgregar.setText("Agregar");
        botonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonMostrar.setBackground(new java.awt.Color(102, 255, 255));
        botonMostrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonMostrar.setForeground(new java.awt.Color(0, 0, 0));
        botonMostrar.setText("Mostrar");
        botonMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        txtNombre1.setText("Horario:");

        cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActionPerformed(evt);
            }
        });

        txtNombre2.setText("Nombre:");

        jLabel2.setText("Identificación Instructor:");

        txtf3.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtNombre2))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtf1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193)
                                .addComponent(botonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNombre1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAtras)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(botonAtras))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre)
                    .addComponent(txtf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre1)
                    .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre2)
                    .addComponent(jLabel2)
                    .addComponent(txtf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        String code = txtf1.getText().toUpperCase();
        String name = Handler.capitalize(txtf2.getText());
        Instructor instructor = RegistroInstructor.instructors.find(Long.parseLong(txtf3.getText()));
        if (instructor == null) {
            Handler.showMessage("La identificación no pertenece a ningún instructor en la base de datos", "Error en la identificación del instructor", Handler.ERROR);
            txtf3.setText("");
            return;
        }
        
        cursos.add(new Curso(code,name, String.valueOf(cmb.getSelectedItem()), instructor, true));
        this.clear();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        cursos.show();
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JComboBox<String> cmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombre1;
    private javax.swing.JLabel txtNombre2;
    private javax.swing.JTextField txtf1;
    private javax.swing.JTextField txtf2;
    private javax.swing.JTextField txtf3;
    // End of variables declaration//GEN-END:variables
}
