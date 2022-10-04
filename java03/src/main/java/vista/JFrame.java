/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import modelo.*;
import control.*;
import vista.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/**
 *
 * @author AndJe        
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public JFrame() {
        Lista <Cuenta> lista = new Lista();
        
        lista.insertar(new Cuenta(2013, 11, 3, 2000, "Pepe"));
        lista.insertar(new Cuenta(2016, 2, 5, 2200, "Ramon"));
        lista.insertar(new Cuenta(2020, 9, 6, 3500, "Carolina"));
        lista.insertar(new Cuenta(2021, 8, 8, 4000, "Maria"));
        lista.insertar(new Cuenta(2022, 2, 6, 12000, "Macias"));
        
        lista.setActual(lista.getInicio());
        
        Cuenta cuentaActual = (Cuenta) lista.getActual().getDato();
        
        initComponents();
        
        numCuenta.setText(""+cuentaActual.getNumCuenta());
        jTextField4.setText("" + cuentaActual.getFecha().get(Calendar.DATE));
        jTextField7.setText("" + cuentaActual.getFecha().get(Calendar.MONTH));
        jTextField8.setText("" + cuentaActual.getFecha().get(Calendar.YEAR));
        a.setText(""+cuentaActual.getSaldo());
        jlabel3.setText(""+cuentaActual.getPropietario());
        
        botonAceptar.setVisible(false);
        botonCancelar.setVisible(false);
        
        botonAnterior.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(lista.getActual().getAnterior() != null){
                    Cuenta C = (Cuenta) lista.getActual().getAnterior().getDato();
                    lista.setActual(lista.getActual().getAnterior());
                    
                    numCuenta.setText("" + C.getNumCuenta());
                    jTextField4.setText("" + C.getFecha().get(Calendar.DATE));
                    jTextField7.setText("" + C.getFecha().get(Calendar.MONTH));
                    jTextField8.setText("" + C.getFecha().get(Calendar.YEAR));
                    a.setText("" + C.getSaldo());
                    jlabel3.setText("" + C.getPropietario());
                }

            }
        });
        
        botonSiguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(lista.getActual().getSiguiente() != null){
                    Cuenta C = (Cuenta) lista.getActual().getSiguiente().getDato();
                    lista.setActual(lista.getActual().getSiguiente());
                    
                    numCuenta.setText("" + C.getNumCuenta());
                    jTextField4.setText(""+C.getFecha().get(Calendar.DATE));
                    jTextField7.setText(""+C.getFecha().get(Calendar.MONTH));
                    jTextField8.setText(""+C.getFecha().get(Calendar.YEAR));
                    a.setText("" + C.getSaldo());
                    jlabel3.setText("" + C.getPropietario());
                }

            }
        });
        
        botonCrear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GregorianCalendar fechaActual = new GregorianCalendar(new Locale("es", "ES"));
                numCuenta.setText("Autonumerico");
                numCuenta.setBackground(Color.GRAY);
                jTextField4.setText("dd");
                jTextField7.setText("mm");
                jTextField8.setText("yyyy");
                a.setText("");
                jlabel3.setText("");
                /*
                propCuenta.setEditable(true);
                saldoCuenta.setEditable(true);
                */
                botonCrear.setVisible(false);
                botonAnterior.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAceptar.setVisible(true);
                botonCancelar.setVisible(true);
                
                botonAceptar.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                        GregorianCalendar fecha = new GregorianCalendar(new Locale("es", "ES"));
                        String dia = jTextField4.getText();
                        String mes = jTextField7.getText();
                        String anio = jTextField8.getText();
                        String prop = jlabel3.getText();
                        float saldo = Float.parseFloat(a.getText());
                        //GregorianCalendar fecha = new GregorianCalendar(new Locale("es", "ES"));
                        
                        if(dia.equalsIgnoreCase("dd") || dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("mm") || mes.equalsIgnoreCase("")
                                || anio.equalsIgnoreCase("yyyy") || anio.equalsIgnoreCase("")){
                            lista.insertar(new Cuenta(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE),saldo, prop));
                        }
                        else
                        {
                            int dia1 = Integer.parseInt(dia);
                            int mes1 = Integer.parseInt(mes);
                            int anio1 = Integer.parseInt(anio);
                            lista.insertar(new Cuenta(anio1, mes1, dia1,saldo, prop));
                        }
                        /*
                        propCuenta.setEditable(false);
                        saldoCuenta.setEditable(false);
                        */
                        jTextField4.setEditable(false);
                        jTextField7.setEditable(false);
                        jTextField8.setEditable(false);
                        numCuenta.setBackground(null);
                        
                        botonSiguiente.setVisible(true);
                        botonAnterior.setVisible(true);
                        botonAceptar.setVisible(false);
                        botonCancelar.setVisible(false);
                        botonCrear.setVisible(true);
                        
                        Cuenta C = (Cuenta) lista.getActual().getDato();
                        refrescarCuenta(C);
                    }
                });
                
                botonCancelar.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                        botonSiguiente.setVisible(true);
                        botonAnterior.setVisible(true);
                        botonAceptar.setVisible(false);
                        botonCancelar.setVisible(false);
                        botonCrear.setVisible(true);
                        
                        numCuenta.setBackground(null);
                        
                        Cuenta C = (Cuenta) lista.getActual().getDato();
                        refrescarCuenta(C);
                    }
                });
            }
        });
    }
    
    public void refrescarCuenta(Cuenta cuenta){
        numCuenta.setText(""+cuenta.getNumCuenta());
        jTextField4.setText(""+cuenta.getFecha().get(Calendar.DATE));
        jTextField7.setText(""+cuenta.getFecha().get(Calendar.MONTH));
        jTextField8.setText(""+cuenta.getFecha().get(Calendar.YEAR));
        a.setText(""+cuenta.getSaldo());
        jlabel3.setText(""+cuenta.getPropietario());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        numCuenta = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jlabel1 = new javax.swing.JTextField();
        salarioCuenta = new javax.swing.JTextField();
        propCuenta = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAnterior.setText("Anterior");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonCrear.setText("Crear Cuenta");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        numCuenta.setText("Numero de cuenta");

        a.setText("Salario");

        jlabel3.setText("Titular");

        jLabel4.setText("Fecha:");

        botonAceptar.setText("Aceptar");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(botonSiguiente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(botonCrear)
                        .addGap(48, 48, 48)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(numCuenta)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salarioCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCuenta)
                    .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel3)
                    .addComponent(propCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAnterior)
                    .addComponent(botonSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCrear)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAnteriorActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Lista <Cuenta> list = new Lista();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jlabel1;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel numCuenta;
    private javax.swing.JTextField propCuenta;
    private javax.swing.JTextField salarioCuenta;
    // End of variables declaration//GEN-END:variables
}
