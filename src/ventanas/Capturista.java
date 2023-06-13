
package ventanas;

import clases.Conexion;
import java.sql.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class Capturista extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    int sesion_usuario;

 
    public Capturista() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario;
        
        setSize(550, 300);
        setResizable(false); 
        setTitle("Capturista - Sesión de " + user);
        setLocationRelativeTo(null);
        
        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel_NombreUsuario.setText("Bienvenido " + nombre_usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error en consultar nombre de capturista.");
        }
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_RegistrarCliente = new javax.swing.JButton();
        jButton_GestionarClientes = new javax.swing.JButton();
        jButton_Imprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_RegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton_RegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jButton_GestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        jButton_GestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jButton_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestionar Clientes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Imprimir Clientes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel7.setText("Creado por KikeCo ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarClienteActionPerformed
        
        RegistrarClientes registrarClientes = new RegistrarClientes();
        registrarClientes.setVisible(true);
        
    }//GEN-LAST:event_jButton_RegistrarClienteActionPerformed

    private void jButton_GestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GestionarClientesActionPerformed
        
        GestionarClientes gestionarClientes = new GestionarClientes();
        gestionarClientes.setVisible(true);
        
    }//GEN-LAST:event_jButton_GestionarClientesActionPerformed

    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ListaClientes.pdf"));
            
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de clientes. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("email");
            tabla.addCell("Télefono");
            tabla.addCell("Dirección");
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    do {                        
                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        
                    } while (rs.next());
                    documento.add(tabla);
                }
                
            } catch (SQLException e) {
                System.err.print("Error al generar lista de clientes. " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de clientes creada correctamente.");
            
        } catch (Exception e) {
            System.err.println("Error al generar PDF " + e);
        }
        
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

   
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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GestionarClientes;
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JButton jButton_RegistrarCliente;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}