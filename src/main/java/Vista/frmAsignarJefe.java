package Vista;

import Controlador.ControlJefe;
import Modelo.Jefe;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class frmAsignarJefe extends javax.swing.JFrame {

    private ControlJefe daoJefe = new ControlJefe();

    public frmAsignarJefe() {
        initComponents();
        ListarJefe();
        MostrarFondoImagen("fondoAsignarJefe");
    }
    
    public void MostrarFondoImagen(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo  .getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }

    public void Filtrar(String cadena) {
        DefaultTableModel dt = (DefaultTableModel) TABLAJEFE.getModel();
        dt.setRowCount(0);

        daoJefe.ListarJefe().stream().filter(f -> f.getNomJefe().toUpperCase().startsWith(cadena)).
                forEach(fi -> dt.addRow(new Object[]{fi.getIdJefe(), fi.getNomJefe()}));
    }

    public void ListarJefe() {
        DefaultTableModel dt = (DefaultTableModel) TABLAJEFE.getModel();
        dt.setRowCount(0);

        for (Jefe x : daoJefe.ListarJefe()) {
            Object[] fila = {x.getIdJefe(), x.getNomJefe()};
            dt.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLAJEFE = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtFiltrar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtAsignarIDJEFE = new javax.swing.JTextField();
        txtASIGNARNOMBREJEFE = new javax.swing.JTextField();
        lblImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtrar por Nombre Completo :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ASIGNAR JEFE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        TABLAJEFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TABLAJEFE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID JEFE", "NOMBRE COMPLETO JEFE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLAJEFE.setRowHeight(32);
        TABLAJEFE.getTableHeader().setReorderingAllowed(false);
        TABLAJEFE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLAJEFEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLAJEFE);
        if (TABLAJEFE.getColumnModel().getColumnCount() > 0) {
            TABLAJEFE.getColumnModel().getColumn(0).setResizable(false);
            TABLAJEFE.getColumnModel().getColumn(0).setPreferredWidth(1);
            TABLAJEFE.getColumnModel().getColumn(1).setResizable(false);
            TABLAJEFE.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 190));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 170, 10));

        txtFiltrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFiltrar.setForeground(new java.awt.Color(51, 0, 255));
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 200, 30));

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Asignar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 90, -1));

        txtAsignarIDJEFE.setEditable(false);
        txtAsignarIDJEFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAsignarIDJEFE.setForeground(new java.awt.Color(0, 0, 255));
        txtAsignarIDJEFE.setBorder(javax.swing.BorderFactory.createTitledBorder("ID JEFE"));
        getContentPane().add(txtAsignarIDJEFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 110, 60));

        txtASIGNARNOMBREJEFE.setEditable(false);
        txtASIGNARNOMBREJEFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtASIGNARNOMBREJEFE.setForeground(new java.awt.Color(0, 0, 255));
        txtASIGNARNOMBREJEFE.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRE COMPLETO JEFE"));
        getContentPane().add(txtASIGNARNOMBREJEFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 210, 60));
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtAsignarIDJEFE.getText().trim().length() <= 0 || txtASIGNARNOMBREJEFE.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("::: Seleccionar Jefe :::");
            return;
        }

        frmEmpleado.txtIDjefe.setText(txtAsignarIDJEFE.getText());
        frmEmpleado.txtNombreJefe.setText(txtASIGNARNOMBREJEFE.getText());

        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TABLAJEFEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAJEFEMouseClicked

        int fila = TABLAJEFE.getSelectedRow();

        txtAsignarIDJEFE.setText(TABLAJEFE.getValueAt(fila, 0).toString());
        txtASIGNARNOMBREJEFE.setText(TABLAJEFE.getValueAt(fila, 1).toString());

    }//GEN-LAST:event_TABLAJEFEMouseClicked

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased
        Filtrar(txtFiltrar.getText().toUpperCase());
    }//GEN-LAST:event_txtFiltrarKeyReleased

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
            java.util.logging.Logger.getLogger(frmAsignarJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsignarJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsignarJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsignarJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsignarJefe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLAJEFE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagenFondo;
    private javax.swing.JTextField txtASIGNARNOMBREJEFE;
    private javax.swing.JTextField txtAsignarIDJEFE;
    private javax.swing.JTextField txtFiltrar;
    // End of variables declaration//GEN-END:variables
}
