package Vista;

import Controlador.ControlEmpleado;
import Modelo.Empleado;
import Modelo.Jefe;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmEmpleado extends javax.swing.JFrame {

    private ControlEmpleado daoEmp = new ControlEmpleado();

    public frmEmpleado() {
        initComponents();
        Limpiar();
        ListarEmpleado();
        MostrarFondoImagen("fondoEmpJefe");
    }

    public void MostrarFondoImagen(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }

    public void FiltrarEmp(String cadena) {
        DefaultTableModel dt = (DefaultTableModel) TABLAEMPLEADO.getModel();
        dt.setRowCount(0);

        daoEmp.ListarEmpleado().stream().filter(f -> f.getNomEmp().toUpperCase().startsWith(cadena)).
                forEach(fi -> dt.addRow(new Object[]{fi.getIdEmp(), fi.getNomEmp(), fi.getFnEmp(),
            fi.getJefe().getIdJefe(), fi.getJefe().getNomJefe()}));
    }

    public void FiltrarJefe(String cadena) {
        DefaultTableModel dt = (DefaultTableModel) TABLAEMPLEADO.getModel();
        dt.setRowCount(0);

        daoEmp.ListarEmpleado().stream().filter(f -> f.getJefe().getNomJefe().toUpperCase().startsWith(cadena)).
                forEach(fi -> dt.addRow(new Object[]{fi.getIdEmp(), fi.getNomEmp(), fi.getFnEmp(),
            fi.getJefe().getIdJefe(), fi.getJefe().getNomJefe()}));
    }

    public void ListarEmpleado() {
        DefaultTableModel dt = (DefaultTableModel) TABLAEMPLEADO.getModel();
        dt.setRowCount(0);

        for (Empleado x : daoEmp.ListarEmpleado()) {
            Object[] fila = {x.getIdEmp(), x.getNomEmp(), x.getFnEmp(), x.getJefe().getIdJefe(), x.getJefe().getNomJefe()};
            dt.addRow(fila);
        }
    }

    public void Limpiar() {
        txtIDemp.setText("" + daoEmp.RetornarCodigoEmpleado());
        txtNombreEmp.setText("");
        txtFechaNaciEmp.setDate(null);

        txtIDjefe.setText("");
        txtNombreJefe.setText("");

        TABLAEMPLEADO.clearSelection();

        btnAgregar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtIDemp = new javax.swing.JTextField();
        txtNombreEmp = new javax.swing.JTextField();
        txtFechaNaciEmp = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        txtIDjefe = new javax.swing.JTextField();
        txtNombreJefe = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLAEMPLEADO = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtFiltrarEmp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFiltrarJefe = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        lblImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE LA TABLA EMPLEADO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 496, 18));

        txtIDemp.setEditable(false);
        txtIDemp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIDemp.setBorder(javax.swing.BorderFactory.createTitledBorder("ID EMP"));
        getContentPane().add(txtIDemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, 60));

        txtNombreEmp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreEmp.setForeground(new java.awt.Color(0, 0, 255));
        txtNombreEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRE COMPLETO EMP"));
        getContentPane().add(txtNombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 270, 60));

        txtFechaNaciEmp.setBackground(new java.awt.Color(0, 0, 255));
        txtFechaNaciEmp.setForeground(new java.awt.Color(0, 0, 255));
        txtFechaNaciEmp.setDateFormatString("yyyy-MM-dd");
        txtFechaNaciEmp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtFechaNaciEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 170, 40));

        jLabel2.setText("FECHA DE NACIMIENTO EMP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 496, 18));

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Asignar Jefe");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        txtIDjefe.setEditable(false);
        txtIDjefe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIDjefe.setBorder(javax.swing.BorderFactory.createTitledBorder("ID JEFE"));
        getContentPane().add(txtIDjefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 70, 60));

        txtNombreJefe.setEditable(false);
        txtNombreJefe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreJefe.setBorder(javax.swing.BorderFactory.createTitledBorder("NOMBRE COMPLETO JEFE"));
        getContentPane().add(txtNombreJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 260, 60));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 496, 18));

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
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

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
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(0, 255, 0));
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
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        TABLAEMPLEADO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TABLAEMPLEADO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID EMP", "NOMBRE COMPLETO EMP", "FECHA NAC. EMP", "ID JEFE", "NOMBRE COMPLETO JEFE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLAEMPLEADO.setRowHeight(32);
        TABLAEMPLEADO.getTableHeader().setReorderingAllowed(false);
        TABLAEMPLEADO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLAEMPLEADOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLAEMPLEADO);
        if (TABLAEMPLEADO.getColumnModel().getColumnCount() > 0) {
            TABLAEMPLEADO.getColumnModel().getColumn(0).setResizable(false);
            TABLAEMPLEADO.getColumnModel().getColumn(0).setPreferredWidth(1);
            TABLAEMPLEADO.getColumnModel().getColumn(1).setResizable(false);
            TABLAEMPLEADO.getColumnModel().getColumn(1).setPreferredWidth(190);
            TABLAEMPLEADO.getColumnModel().getColumn(2).setResizable(false);
            TABLAEMPLEADO.getColumnModel().getColumn(2).setPreferredWidth(120);
            TABLAEMPLEADO.getColumnModel().getColumn(3).setResizable(false);
            TABLAEMPLEADO.getColumnModel().getColumn(3).setPreferredWidth(1);
            TABLAEMPLEADO.getColumnModel().getColumn(4).setResizable(false);
            TABLAEMPLEADO.getColumnModel().getColumn(4).setPreferredWidth(190);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 690, 150));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Filtrar por Nombre Completo del Jefe");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        txtFiltrarEmp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFiltrarEmp.setForeground(new java.awt.Color(0, 0, 255));
        txtFiltrarEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarEmpKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltrarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 250, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Filtrar por Nombre Completo del Empleado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txtFiltrarJefe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFiltrarJefe.setForeground(new java.awt.Color(0, 0, 255));
        txtFiltrarJefe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarJefeKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltrarJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 250, 30));

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
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        lblImagenFondo.setText("jLabel5");
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtNombreEmp.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("Nombre vacío");
            return;
        }

        if (txtFechaNaciEmp.getDate() == null) {
            Util.Mensajes.MsgAdvertencia("::: Seleccionar fecha de nacimiento :::");
            return;
        }

        if (txtNombreJefe.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("::: Seleccionar Jefe :::");
            return;
        }

        String nombre = txtNombreEmp.getText();
        Date fecha = new Date(txtFechaNaciEmp.getDate().getTime());
        int idJefe = Integer.parseInt(txtIDjefe.getText());

        Jefe jefe = new Jefe();
        jefe.setIdJefe(idJefe);

        Empleado e = new Empleado();
        e.setNomEmp(nombre);
        e.setFnEmp(fecha);
        e.setJefe(jefe);

        int res = daoEmp.AgregarEmpleado(e);

        if (res > 0) {
            Util.Mensajes.MsgSatisfactorio("Empleado agregado correctamente");
        } else {
            Util.Mensajes.MsgError("No se pudo agregar al Empleado");
        }

        ListarEmpleado();
        Limpiar();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        frmAsignarJefe vista = new frmAsignarJefe();
        vista.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtNombreEmp.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("Nombre vacío");
            return;
        }

        if (txtFechaNaciEmp.getDate() == null) {
            Util.Mensajes.MsgAdvertencia("::: Seleccionar fecha de nacimiento :::");
            return;
        }

        if (txtNombreJefe.getText().trim().length() <= 0) {
            Util.Mensajes.MsgAdvertencia("::: Seleccionar Jefe :::");
            return;
        }

        int idEmp = Integer.parseInt(txtIDemp.getText());
        String nomEmp = txtNombreEmp.getText();
        Date fechaEmp = new Date(txtFechaNaciEmp.getDate().getTime());

        int idJefe = Integer.parseInt(txtIDjefe.getText());

        Jefe jefe = new Jefe();
        jefe.setIdJefe(idJefe);

        Empleado e = new Empleado(idEmp, nomEmp, fechaEmp, jefe);

        int res = daoEmp.ActualizarEmpleado(e);

        if (res > 0) {
            Util.Mensajes.MsgSatisfactorio("Empleado actualizado correctamente");
        } else {
            Util.Mensajes.MsgError("No se pudo actualizar al Empleado");
        }

        ListarEmpleado();
        Limpiar();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (Util.Mensajes.MsgPregunta("¿Estas seguro que desea eliminar el Empleado " + txtNombreEmp.getText() + " ?") == 0) {
            int idEmp = Integer.parseInt(txtIDemp.getText());

            int res = daoEmp.EliminarEmpleado(idEmp);

            if (res > 0) {
                Util.Mensajes.MsgSatisfactorio("Empleado eliminado correctamente");
            } else {
                Util.Mensajes.MsgError("No se pudo eliminar al Empleado");
            }

            ListarEmpleado();
            Limpiar();
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TABLAEMPLEADOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAEMPLEADOMouseClicked

        int fila = TABLAEMPLEADO.getSelectedRow();

        txtIDemp.setText(TABLAEMPLEADO.getValueAt(fila, 0).toString());
        txtNombreEmp.setText(TABLAEMPLEADO.getValueAt(fila, 1).toString());
        txtFechaNaciEmp.setDate((Date) TABLAEMPLEADO.getValueAt(fila, 2));
        txtIDjefe.setText(TABLAEMPLEADO.getValueAt(fila, 3).toString());
        txtNombreJefe.setText(TABLAEMPLEADO.getValueAt(fila, 4).toString());

        btnAgregar.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);

    }//GEN-LAST:event_TABLAEMPLEADOMouseClicked

    private void txtFiltrarEmpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarEmpKeyReleased

        FiltrarEmp(txtFiltrarEmp.getText().toUpperCase());

    }//GEN-LAST:event_txtFiltrarEmpKeyReleased

    private void txtFiltrarJefeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarJefeKeyReleased
        FiltrarJefe(txtFiltrarJefe.getText().toUpperCase());
    }//GEN-LAST:event_txtFiltrarJefeKeyReleased

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmIndex vista = new frmIndex();
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
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLAEMPLEADO;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblImagenFondo;
    private com.toedter.calendar.JDateChooser txtFechaNaciEmp;
    private javax.swing.JTextField txtFiltrarEmp;
    private javax.swing.JTextField txtFiltrarJefe;
    private javax.swing.JTextField txtIDemp;
    public static javax.swing.JTextField txtIDjefe;
    private javax.swing.JTextField txtNombreEmp;
    public static javax.swing.JTextField txtNombreJefe;
    // End of variables declaration//GEN-END:variables
}
