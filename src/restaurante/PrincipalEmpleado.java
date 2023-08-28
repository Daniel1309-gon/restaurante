/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author danig
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PrincipalEmpleado extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost/parcial3";
    String user = "root";
    String pass = "";
    /**
     * Creates new form PrincipalEmpleado
     */
    public PrincipalEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Restaurante las Delicias");
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
        botonMenus = new javax.swing.JButton();
        botonVentas = new javax.swing.JButton();
        modificarInfoEmpleado = new javax.swing.JButton();
        botonPedidos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonMenus.setText("MENÚS");
        botonMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenusActionPerformed(evt);
            }
        });

        botonVentas.setText("VENTAS");
        botonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVentasActionPerformed(evt);
            }
        });

        modificarInfoEmpleado.setText("MODIFICAR INFO.");
        modificarInfoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarInfoEmpleadoActionPerformed(evt);
            }
        });

        botonPedidos.setText("PEDIDOS");
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });

        jButton1.setText("CERRAR SESIÓN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMenus)
                    .addComponent(botonPedidos))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modificarInfoEmpleado)
                    .addComponent(botonVentas))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonMenus)
                    .addComponent(botonVentas))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPedidos)
                    .addComponent(modificarInfoEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        modificarInfoEmpleado.setText("MODIFICAR \nINFO.");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarInfoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarInfoEmpleadoActionPerformed
        ActualizarDatosEmpleado actualizarDatosEmpleado = new ActualizarDatosEmpleado();
        this.setVisible(false);
        actualizarDatosEmpleado.setVisible(true);
        actualizarDatosEmpleado.txtNombreActualizar.setText(new Ingreso().usuarioSISTEMA);
    }//GEN-LAST:event_modificarInfoEmpleadoActionPerformed

    private void botonMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenusActionPerformed
        Menus menus = new Menus();
        this.setVisible(false);
        menus.setVisible(true);
    }//GEN-LAST:event_botonMenusActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        InterfazPedidos interfazPedidos = new InterfazPedidos();
        this.setVisible(false);
        interfazPedidos.setVisible(true);
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVentasActionPerformed
        Document reporte = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(reporte, new FileOutputStream(ruta + "/OneDrive/Escritorio/ReporteVentas.pdf"));
            reporte.open();
            
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Nombre cliente");
            tabla.addCell("Producto");
            tabla.addCell("Precio");
            tabla.addCell("Empleado");
            
            try {
                Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement pst  = con.prepareStatement("SELECT * FROM pedidosrestaurante");
                
                ResultSet result = pst.executeQuery();
                
                while(result.next())
                {
                    tabla.addCell(result.getString(1));
                    tabla.addCell(result.getString(2));
                    tabla.addCell(result.getString(3));
                    tabla.addCell(result.getString(4));
                }
                reporte.add(tabla);
            } catch (DocumentException | SQLException e) {
            }
            reporte.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_botonVentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ingreso ingreso = new Ingreso();
        ingreso.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMenus;
    private javax.swing.JButton botonPedidos;
    private javax.swing.JButton botonVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modificarInfoEmpleado;
    // End of variables declaration//GEN-END:variables
}