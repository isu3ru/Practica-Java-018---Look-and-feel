/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Dependencias.BaseDeDatos;
import Dependencias.EdisoncorSx.WindowsUtil;

import javax.swing.*;

/**
 *
 * @author Alfonso Andrés
 */
@SuppressWarnings("serial")
public class JFramePrincipal extends javax.swing.JFrame{

    public JFramePrincipal(){
        super();
        initComponents();
    }

    private void initComponents() {
        BaseDeDatos.getInstance().crearMaterias();
        setLayout(new java.awt.BorderLayout());
        JPanelContenedor jpanelcontenedor1 = new JPanelContenedor();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        add(jpanelcontenedor1);
//        TitleBar titleBar = new TitleBar();
//        add(titleBar,java.awt.BorderLayout.NORTH);
   //     this.setUndecorated(true);
        this.setTitle("Práctica Java 018");
        this.pack();
        this.setMinimumSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Imagen001.png")).getImage());
    //    this.getContentPane().setBackground(Color.BLACK);
        WindowsUtil.makeWindowsOpacity(this, .90f);
//        WindowsUtil.makeWindowsShape(this,new PanelNice().getShape());
//        new WindowDragger(this,titleBar);
//        titleBar.addCloseAction(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                System.exit(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//            }
//        });
    }
    
}
