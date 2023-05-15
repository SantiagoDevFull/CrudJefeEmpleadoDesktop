package Vista;

import Controlador.ControlJefe;
import Modelo.Empleado;
import Modelo.Jefe;
import Util.Mensajes;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class frmJefe extends javax.swing.JFrame {

    private ControlJefe daoJefe = new ControlJefe();

    private int NumeroEmpleados = 0;

    public frmJefe() {
        initComponents();
        Limpiar();
        ListarJefe();
        MostrarFondoImagen("fondoEmpJefe");
    }

    public void MostrarFondoImagen(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }
    
    public void Filtrar(String cadena) {
        DefaultTableModel dt = (DefaultTableModel) TABLAJEFE.getModel();
        dt.setRowCount(0);

        daoJefe.ListarJefe().stream().filter(f -> f.getNomJefe().toUpperCase().startsWith(cadena)).
                forEach(fi -> dt.addRow(new Object[]{fi.getIdJefe(), fi.getNomJefe(), fi.getNumEmpleados()}));
    }

    public void ListarJefe() {
        DefaultTableModel dt = (DefaultTableModel) TABLAJEFE.getModel();
        dt.setRowCount(0);

        for (Jefe x : daoJefe.ListarJefe()) {
            Object[] fila = {x.getIdJefe(), x.getNomJefe(), x.getNumEmpleados()};
            dt.addRow(fila);
        }
    }

    public void Limpiar() {
        txtID.setText("" + daoJefe.RetornarCodigoJefe());
        txtNombre.setText("");

        TABLAJEFE.clearSelection();

        btnVer.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLAJEFE = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtID = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        lblImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE LA TABLA JEFE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRE COMPLETO"));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 74, 250, 60));

        TABLAJEFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TABLAJEFE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE COMPLETO", "#EMPLEADOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            TABLAJEFE.getColumnModel().getColumn(2).setResizable(false);
            TABLAJEFE.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 490, 160));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 440, 20));

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 74, 80, 60));

        btnAgregar.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(0, 255, 51));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        btnVer.setBackground(new java.awt.Color(102, 255, 255));
        btnVer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVer.setText("Ver Empleados");
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVer.setEnabled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        getContentPane().add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Filtrar por Nombre Completo : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtFiltrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFiltrar.setForeground(new java.awt.Color(0, 0, 255));
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 250, 30));

        btnRegresar.setBackground(new java.awt.Color(255, 51, 0));
        btnRegresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtNombre.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("Nombre vacío");
            return;
        }

        String nombre = txtNombre.getText();

        Jefe x = new Jefe();
        x.setNomJefe(nombre);

        int res = daoJefe.AgregarJefe(x);

        if (res > 0) {
            Util.Mensajes.MsgSatisfactorio("Jefe agregado correctamente");
        } else {
            Util.Mensajes.MsgError("No se pudo agregar al Jefe");
        }

        ListarJefe();
        Limpiar();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtNombre.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("Nombre vacío");
            return;
        }

        int id = Integer.parseInt(txtID.getText());
        String nombre = txtNombre.getText();

        Jefe x = new Jefe(id, nombre);

        int res = daoJefe.ActualizarJefe(x);

        if (res > 0) {
            Util.Mensajes.MsgSatisfactorio("Jefe actualizado correctamente");
        } else {
            Util.Mensajes.MsgError("No se pudo actualizar al Jefe");
        }

        ListarJefe();
        Limpiar();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (NumeroEmpleados > 0) {
            Mensajes.MsgAdvertencia("No se puede eliminar a un Jefe que tiene Empleados registrados");
            return;
        }

        int id = Integer.parseInt(txtID.getText());

        int res = daoJefe.EliminarJefe(id);

        if (res > 0) {
            Util.Mensajes.MsgSatisfactorio("Jefe eliminado correctamente");
        } else {
            Util.Mensajes.MsgError("No se pudo eliminar al Jefe");
        }

        ListarJefe();
        Limpiar();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void TABLAJEFEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAJEFEMouseClicked

        int fila = TABLAJEFE.getSelectedRow();

        txtID.setText(TABLAJEFE.getValueAt(fila, 0).toString());
        txtNombre.setText(TABLAJEFE.getValueAt(fila, 1).toString());
        NumeroEmpleados = (int) TABLAJEFE.getValueAt(fila, 2);

        btnVer.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnActualizar.setEnabled(true);

    }//GEN-LAST:event_TABLAJEFEMouseClicked

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed

        String mensaje = "ID\tNOMBRE COMPLETO\t\tFECHA NACIMIENTO\n\n";
        int id = Integer.parseInt(txtID.getText());

        for (Empleado x : daoJefe.VerEmpleados(id)) {
            mensaje += x.getIdEmp() + "\t" + x.getNomEmp() + "\t" + x.getFnEmp() + "\n";
        }

        Util.Mensajes.MsgTextArea(mensaje);

    }//GEN-LAST:event_btnVerActionPerformed

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased
        
        Filtrar(txtFiltrar.getText().toUpperCase());
        
    }//GEN-LAST:event_txtFiltrarKeyReleased

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       frmIndex vista=new frmIndex();
       vista.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmJefe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLAJEFE;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagenFondo;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
