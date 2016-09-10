package dai_image_main;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.Base64;
import java.awt.ComponentOrientation;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Eduardo
 */
public class ViewImage extends javax.swing.JFrame {

    JFileChooser fileChooser;
    String base64String;
    public ViewImage() 
    {
        this.setUndecorated(true);
        initComponents();
        inicializarComponentes();
    }
/*----------------------------------------------------------------------------*/            
    private void inicializarComponentes(){
/*----------------------------------------------------------------------------*/        
        fileChooser=new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);   
    }
/*----------------------------------------------------------------------------*/    
    private void mostrarRuta(){
/*----------------------------------------------------------------------------*/        
        java.io.File archivo=null;
        fileChooser.showOpenDialog(getRootPane());
        archivo=fileChooser.getSelectedFile();
        if (archivo!=null) 
        {
           jTextField1.setText(archivo.getAbsolutePath());
        }
    }
/*----------------------------------------------------------------------------*/    
    private void mostrarRutaDestino(){
/*----------------------------------------------------------------------------*/        
        java.io.File archivo=null;
        fileChooser.showOpenDialog(getRootPane());
        archivo=fileChooser.getSelectedFile();
        if (archivo!=null) 
        {
           jTextFieldBuscardestino.setText(archivo.getAbsolutePath());
        }
    }    
/*----------------------------------------------------------------------------*/        
    private void mostrarImagen(String ruta){
/*----------------------------------------------------------------------------*/                
        ImageIcon icon = new ImageIcon(ruta);  
        jLabel1.setIcon(icon);  
    }    
    
/*----------------------------------------------------------------------------*/        
    private void codificarImagen(String ruta, String tipo) throws IOException{
/*----------------------------------------------------------------------------*/                    
        try {
        //#Esta clase implementa un flujo de salida en el que se escriben los datos en una matriz de bytes
        //#Los datos se pueden recuperar usando toByteArray() o toString    
        ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
        //#ACCEDE A LOS DATOS DE UNA IMAGEN
        BufferedImage img=ImageIO.read(new File(ruta));
        //#Creamos un nuevo archivo
        ImageIO.write(img, tipo, baos);
        //#Se usa flush ya que BAOS causaria desbordamiento de la memoria sin flush o close.
        //#Recolector de basura.
        baos.flush();
        //#DE LOS X BYTES SE UNEN UN BUFER DE 24 BITS, LOS CUALES SE VAN EMPAQUETANDO DE 6 BITS DE 64 VALORES BIN DIF 
        //#TERMINAN CONVIRTIENDOSE EN 4 NUMERO (24=4*6BITS) QUE LUEGO SE CONVIENTEN EN SU VALORES CORRESPONDIENTES DE BASE64
        base64String=Base64.getEncoder().encodeToString(baos.toByteArray());
        
        baos.close();
        //#Los métodos de esta clase pueden ser llamados después de que el flujo se ha cerrado sin generar un IOException .
        jTextArea1.setComponentOrientation(ComponentOrientation.UNKNOWN);
        jTextArea1.setText(base64String);
        jLabelBuffer.setText(String.valueOf(baos.size()));
        
        } catch (Exception e) {System.out.println(e);}
    }    
/*----------------------------------------------------------------------------*/    
    private void decodificarImagen(String base64, String ruta,String nombreImagen,String tipo) throws IOException{
/*----------------------------------------------------------------------------*/                
            //#Desencripta
            byte[] bytearray =  Base64.getDecoder().decode(base64);
            BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytearray));
            ImageIO.write(imag, tipo, new File(ruta,nombreImagen+"."+tipo));
            
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelBuffer = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox();
        jButtonCrear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabelmessage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JLabel();
        jTextFieldBuscardestino = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1370, 730));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jTextArea1.setBackground(new java.awt.Color(16, 17, 17));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 204, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 570, 400);

        jLabel1.setBackground(new java.awt.Color(16, 17, 17));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jScrollPane2.setViewportView(jLabel1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(590, 150, 380, 400);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/push2.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pushHover2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(540, 50, 38, 40);

        jLabelBuffer.setBackground(new java.awt.Color(16, 17, 17));
        jLabelBuffer.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabelBuffer.setForeground(new java.awt.Color(204, 204, 204));
        jLabelBuffer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuffer.setOpaque(true);
        jPanel1.add(jLabelBuffer);
        jLabelBuffer.setBounds(1190, 50, 160, 40);

        jTextFieldNombre.setBackground(new java.awt.Color(16, 17, 17));
        jTextFieldNombre.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(153, 255, 0));
        jTextFieldNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombre.setBorder(null);
        jTextFieldNombre.setCaretColor(new java.awt.Color(204, 255, 0));
        jPanel1.add(jTextFieldNombre);
        jTextFieldNombre.setBounds(640, 620, 140, 40);

        jComboBoxTipo.setBackground(new java.awt.Color(16, 17, 17));
        jComboBoxTipo.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jComboBoxTipo.setForeground(new java.awt.Color(204, 204, 204));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "jpg", "gif", "png" }));
        jComboBoxTipo.setOpaque(false);
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxTipo);
        jComboBoxTipo.setBounds(840, 620, 130, 40);

        jButtonCrear.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCrear);
        jButtonCrear.setBounds(980, 620, 150, 40);

        jLabel2.setBackground(new java.awt.Color(16, 17, 17));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jScrollPane3.setViewportView(jLabel2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(980, 150, 370, 400);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save3.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/saveHover2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 620, 40, 40);

        jLabelmessage.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelmessage.setForeground(new java.awt.Color(51, 255, 0));
        jPanel1.add(jLabelmessage);
        jLabelmessage.setBounds(650, 60, 470, 20);

        jTextField1.setBackground(new java.awt.Color(16, 17, 17));
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setOpaque(true);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 50, 520, 40);

        jTextFieldBuscardestino.setBackground(new java.awt.Color(16, 17, 17));
        jTextFieldBuscardestino.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextFieldBuscardestino.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldBuscardestino.setOpaque(true);
        jPanel1.add(jTextFieldBuscardestino);
        jTextFieldBuscardestino.setBounds(60, 620, 520, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filename2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(590, 620, 40, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/type2.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(790, 620, 40, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bufferico.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1140, 50, 40, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/message2.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(590, 50, 545, 40);

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utl.png"))); // NOI18N
        jLabel8.setText(" Desarrollo de aplicaciones/Algoritmo_base64");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 0, 610, 30);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 1370, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    /*==========================================================================
    BOTON BUSCAR DIRECCIÓN ORIGEN Y ARCHIVO A CODIFICAR
    ==========================================================================*/    
        try {
            mostrarRuta();
            String ruta=jTextField1.getText();
            mostrarImagen(ruta);
            String tipoImagen=String.valueOf(jComboBoxTipo.getSelectedItem());
            codificarImagen(ruta,tipoImagen);
            jLabelmessage.setText("¡Imagen codificada con exito!");
        } catch (Exception e) {System.out.println(e);}   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
    /*==========================================================================
     BOTON CREAR Y DECODIFICAR IMAGEN APARTIR DE CODIFICACIÓN BASE64
    ==========================================================================*/        
        try {
            String ruta=jTextFieldBuscardestino.getText();
            String nombreImagen=jTextFieldNombre.getText();
            String tipoImagen=String.valueOf(jComboBoxTipo.getSelectedItem());
            decodificarImagen(base64String, ruta, nombreImagen, tipoImagen);
            ImageIcon icono = new ImageIcon(ruta+"\\"+nombreImagen+"."+tipoImagen);  
            jLabel2.setIcon(icono);  
            jLabelmessage.setText("¡Imagen guardada y decodificada con exito!");
        } catch (Exception e) {System.out.println(e);}
        
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    /*==========================================================================
     BOTON BUSCAR DESTINO
    ==========================================================================*/                
        mostrarRutaDestino();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelBuffer;
    private javax.swing.JLabel jLabelmessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jTextField1;
    private javax.swing.JLabel jTextFieldBuscardestino;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
