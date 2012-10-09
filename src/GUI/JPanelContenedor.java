/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Dependencias.BaseDeDatos;
import Dependencias.EdisoncorSx.ButtonAction;
import Dependencias.EdisoncorSx.LabelMetric;
import Dependencias.EdisoncorSx.PanelCurves;
import Dependencias.EdisoncorSx.PanelRect;
import Dependencias.Estudiante;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alfonso Andrés
 */
@SuppressWarnings("serial")
public class JPanelContenedor extends PanelRect{

    private JPanel[] jpanel;
    private PanelCurves panelcurves1;
    private ButtonAction[] jbutton;
    private JTextField[] jtextfield;
    private JComboBox[] jcombobox;
    private final int topeJTextField=5;
    private final int topeJComboBox=3;
    private final int topeCarreras=14;
    private Estudiante estudiante;
    private javax.swing.JFrame jframe1=null;
    private JList jlist1;
    private DefaultListModel model;
    private boolean controladoreventos=true,editing=true;
    private BufferedImage imagen;
    
    public JPanelContenedor() {
        super();
        initComponents();
    }

    private void initComponents() {
        Image img=new ImageIcon(getClass().getResource("/Imagenes/Imagen003.png")).getImage();
        imagen=new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2=imagen.createGraphics();
        g2.drawImage(img,null,this);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,java.awt.RenderingHints.VALUE_ANTIALIAS_ON );

        panelcurves1=new PanelCurves();
        setLayout(new java.awt.BorderLayout());
        add(panelcurves1);
        JPanel jpanel1=new JPanel(){
            private static final long serialVersionUID = 1L;
            public void paintComponent(java.awt.Graphics g) {
                    g.drawImage(imagen, 40,0,null, this);
                }
        };
        jpanel1.setOpaque(false);
        jpanel1.add(javax.swing.Box.createVerticalStrut(5));
        LabelMetric label=new LabelMetric();
        label.setIcon(new ImageIcon(imagen));
        jpanel1.add(label);
        panelcurves1.add(jpanel1,java.awt.BorderLayout.NORTH);
        initJPanel();
        initJLabel();
        initJComboBox();
        initJTextField();
        initJButton();
        initJList();
    }

    private void initJButton() {
        int topeJButton = 3;
        jbutton=new ButtonAction[topeJButton];
        Controladores.ControladorBotones action=new Controladores.ControladorBotones(this);
        JPanel jpanel1=new JPanel(new java.awt.FlowLayout(8,12,12)),
                jpanel2=new JPanel(new java.awt.BorderLayout()),
                jpanel3=new JPanel();
        jpanel1.setOpaque(false);
        jpanel2.setOpaque(false);
        jpanel3.setOpaque(false);
        for(int i=0;i< topeJButton;i++){
            jbutton[i]=new ButtonAction(getNameJButton(i));
            jbutton[i].setActionCommand(jbutton[i].getText());
            jbutton[i].addActionListener(action);
            jbutton[i].setPreferredSize(new java.awt.Dimension(70,27));
            jpanel1.add(jbutton[i]);
        }
        JPanel jpanel4=new JPanel(new java.awt.BorderLayout());
        jpanel4.setOpaque(false);
        jpanel4.add(javax.swing.Box.createHorizontalStrut(15),java.awt.BorderLayout.WEST);
        jpanel4.add(jpanel1,java.awt.BorderLayout.EAST);
        jpanel2.add(jpanel4,java.awt.BorderLayout.WEST);
        jpanel2.add(jpanel3,java.awt.BorderLayout.CENTER);
//        jpanel2.add(javax.swing.Box.createHorizontalStrut(15),java.awt.BorderLayout.EAST);
        jpanel3.add(jcombobox[2]);
        panelcurves1.add(jpanel2,java.awt.BorderLayout.SOUTH);
    }

    private void initJLabel() {
        int topeJLabel = 8;
        LabelMetric[] jlabel = new LabelMetric[topeJLabel];
        int indice;
        for(int i=0;i< topeJLabel;i++){
            jlabel[i]=new LabelMetric();
            jlabel[i].setText(this.getNameJLabel(i));
            if(i<5)
                indice=8;
            else
                indice=9;
            jpanel[i].add(jlabel[i]);
            jpanel[indice].add(jpanel[i]);
        }
    }

    private void initJTextField() {
        jtextfield=new JTextField[topeJTextField];
        Controladores.ControladorJTextField controlador=new Controladores.ControladorJTextField(this);
        for(int i=0;i<topeJTextField;i++){
            jtextfield[i]=new JTextField(20);
            if(i<4){
                jtextfield[i].setActionCommand(getNameJLabel(i));
                jtextfield[i].addKeyListener(controlador);
            }
            jpanel[i].add(jtextfield[i]);
        }
        jpanel[7].add(jtextfield[4]);
        jtextfield[4].setEditable(false);
        jtextfield[4].setColumns(14);
    }
    public JTextField getJTextField(int i){
        return jtextfield[i];
    }
    
    private void initJComboBox() {
        jcombobox=new JComboBox[topeJComboBox];
        for(int i=0;i<topeJComboBox;i++){
            jcombobox[i]=new JComboBox();
            jcombobox[i].addItem(getItemInicialJComboBox(i));
            addItemsJComboBox(i);
            jcombobox[i].setActionCommand(getActionCommandJComboBox(i));
            jcombobox[i].addActionListener(new Controladores.ControladorJComboBox(this));
        }
        jpanel[4].add(jcombobox[0]);
        jpanel[5].add(jcombobox[1]);
    }

    private void initJPanel() {

        int topeJPanel = 11;
        jpanel=new JPanel[topeJPanel];
        JPanel jpanel1=new JPanel(new java.awt.BorderLayout());
        jpanel1.setOpaque(false);
        for(int i=0;i< topeJPanel;i++){
            jpanel[i]=new JPanel();
            jpanel[i].setOpaque(false);
            if(i>=8)
                jpanel[i].setLayout(new javax.swing.BoxLayout(jpanel[i],javax.swing.BoxLayout.Y_AXIS));
        }
        jpanel1.add(javax.swing.Box.createHorizontalStrut(30),java.awt.BorderLayout.WEST);
        jpanel1.add(jpanel[8],java.awt.BorderLayout.EAST);
        jpanel1.setOpaque(false);
        panelcurves1.add(jpanel1,java.awt.BorderLayout.WEST);
        panelcurves1.add(jpanel[9],java.awt.BorderLayout.CENTER);
        panelcurves1.add(javax.swing.Box.createHorizontalStrut(15),java.awt.BorderLayout.EAST);
       
    }
    
    private void initJList(){
        jlist1=new javax.swing.JList();
        jlist1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlist1.setPreferredSize(new java.awt.Dimension(215,76));
        model=new DefaultListModel();
        jlist1.setModel(model);
        jpanel[6].add(jlist1);
        jlist1.addListSelectionListener(new Controladores.ControladorJList(this));
    }
    
    private String getNameJButton(int i) {
        if(i==0) return "Ingresar";
        if(i==1) return "Editar";
        return "Eliminar";
    }
    
    private String getNameJLabel(int i) {
        int opcion=0;
        if(i==opcion++) return "Nombre ";
        if(i==opcion++) return "Apellido";
        if(i==opcion++) return "Cedula  ";
        if(i==opcion++) return "Edad     ";
        if(i==opcion++) return "Carrera";
        if(i==opcion++) return "Materia ";
        if(i==opcion++) return "Seccion";
        return "Seccion seleccionada";
    }
 
    public boolean datosNoEstanLlenos(){
        for(int i=0;i<topeJTextField-1;i++){
            if(jtextfield[i].getText().isEmpty())
                return true;
        }
        for(int i=0;i<topeJComboBox;i++){
            if(i!=2)
                if(jcombobox[i].getSelectedIndex()==0)
                    return true;
        }
        return jlist1.getSelectedIndex() == -1;
    }

    public Estudiante getEstudiante(){
        int index=0;
        String nombre=jtextfield[index++].getText();
        String apellido=jtextfield[index++].getText();
        int cedula=Integer.parseInt(jtextfield[index++].getText());
        int edad=Integer.parseInt(jtextfield[index++].getText());
        String carrera=jcombobox[0].getSelectedItem()+"";
        String materia=jcombobox[1].getSelectedItem()+"";
        int seccion=((Dependencias.Seccion)model.getElementAt(jlist1.getSelectedIndex())).getSeccion();
        estudiante=new Estudiante(carrera,materia,seccion,nombre,apellido,cedula,edad);
        return estudiante;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public boolean isEditing() {
        return editing;
    }
    
    public void borrarCampo() {
        estudiante=null;
        borrarDatos();
    }

    public int getIndiceEstudianteSeleccionado() {
        return jcombobox[2].getSelectedIndex();
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        if(estudiante==null){
            borrarDatos();
            return;
        }
        cargarDatos();
    }

    private void cargarDatos() {
        int index=0;
        jtextfield[index++].setText(this.estudiante.getNombre());
        jtextfield[index++].setText(this.estudiante.getApellido());
        jtextfield[index++].setText("" + this.estudiante.getCedula());
        jtextfield[index++].setText("" + this.estudiante.getEdad());
        jtextfield[index++].setText("Seccion "+this.estudiante.getSeccion());
        for(int i = 0;i < 2; i++) {
            jcombobox[i].setSelectedIndex(getIndiceJComboBox(i));
        }
        this.cargarElementosJList();
    }

    private void borrarDatos() {
        for(int i = 0; i < topeJTextField; i++) {
            jtextfield[i].setText("");
        }
        for(int i=0;i<topeJComboBox;i++) {
            if(i!=2)
                jcombobox[i].setSelectedIndex(0);
        }
        this.cargarElementosJList();
    }

    public void bloquearCampos() {
        for(int i=0;i<topeJTextField;i++) {
            jtextfield[i].setEditable(false);
        }
        for(int i=0;i<topeJComboBox;i++) {
            if(i!=2)
                jcombobox[i].setEnabled(false);
        }
        jlist1.setEnabled(false);
    }

    public void agregarNombre() {
        jcombobox[2].addItem(estudiante);
    }
    
    public void removerNombre(){
        jcombobox[2].removeItemAt(jcombobox[2].getSelectedIndex());
        jcombobox[2].setSelectedIndex(0);
    }

    public boolean isCamposBloqueados() {
        return !jtextfield[1].isEditable();
    }

    public void desbloquearCampos() {
        for(int i=0;i<topeJTextField-1;i++) {
            jtextfield[i].setEditable(true);
        }
        for(int i=0;i<topeJComboBox;i++) {
            if(i!=2)
                jcombobox[i].setEnabled(true);
        }
        jlist1.setEnabled(true);
    }

    public void setEstudianteSeleccionado(int i) {
        jcombobox[2].setSelectedIndex(i);
    }

    public Estudiante getEstudianteSeleccionado(){
        return (Estudiante)jcombobox[2].getSelectedItem();
    }
    
    public void actualizarNombre() {
        jcombobox[2].insertItemAt(estudiante,jcombobox[2].getSelectedIndex());
        jcombobox[2].removeItemAt(jcombobox[2].getSelectedIndex());
    }

    private String getActionCommandJComboBox(int i) {
        if(i==0) return "Carrera";
        if(i==1) return "Materias";
        return "Listado";
    }

    public boolean isControladorEventos() {
        return controladoreventos;
    }

    public void setControladorEventos(boolean controladoreventos) {
        this.controladoreventos = controladoreventos;
    }

    private String getItemInicialJComboBox(int i) {
        if(i==0) return "Carrera que esta cursando" + espacios(6) ;
        if(i==1) return "Materia a cursar"+espacios(38) ;
        return "Estudiantes Agregados"+espacios(45);
    }

    private String espacios(int i) {
        if(i==0) return " ";
        return " "+espacios(--i);
    }

    private void addItemsJComboBox(int i) {
        if(i==0){
            for(int j=0;j<topeCarreras;j++){
                jcombobox[i].addItem(getNombreCarreras(j));
            }
        }else if(i==1){
            for(BaseDeDatos.Materias materia : BaseDeDatos.Materias.values()){
                if(materia == BaseDeDatos.Materias.CANTIDAD)
                    return;
                jcombobox[i].addItem(materia);
            }
        }
    }

    private int getIndiceMateria() {
        for(BaseDeDatos.Materias materia : BaseDeDatos.Materias.values()){
            if(materia.toString().equals(estudiante.getMateria()))
                return materia.ordinal() + 1;
        }
//        for(int i=0;i<BaseDeDatos.getTopeMaterias();i++) {
//            if(BaseDeDatos.getNombreMaterias(i).equals(estudiante.getMateria()))
//                return i + 1;
//        }
        return 0;
    }

    private String getNombreCarreras(int i) {
        int opcion=0;
        if(i==opcion++) return "Administracion";
        if(i==opcion++) return "Arquitectura";
        if(i==opcion++) return "Contaduria Publica";
        if(i==opcion++) return "Ing. Civil";
        if(i==opcion++) return "Ing. Computacion";
        if(i==opcion++) return "Ing. Electrica";
        if(i==opcion++) return "Ing. Industrial";
        if(i==opcion++) return "Ing. Mecanica";
        if(i==opcion++) return "Ing. Petroleo";
        if(i==opcion++) return "Ing Quimica";
        if(i==opcion++) return "Ing. Sistemas";
        if(i==opcion++) return "Medicina";
        if(i==opcion++) return "Tecnol. Electronica";
        return "Tecnol. Fab. Mecanica";

    }

    private int getIndiceJComboBox(int i) {
        if(i==0){
            for(int j=0;j<this.topeCarreras;j++) {
                if(getNombreCarreras(j).equals(estudiante.getCarrera()))
                    return j + 1;
            }
        }
        return getIndiceMateria();
    }

    public void cargarElementosJList() {
        model.clear();
        if(jcombobox[1].getSelectedIndex()!=0){
            java.util.ArrayList<Dependencias.Seccion> seccion = BaseDeDatos.getInstance().getSecciones(jcombobox[1].getSelectedIndex()-1);
            for(int size=seccion.size(),i=0;i<size;i++){
                model.addElement(seccion.get(i));
                if(estudiante!=null)
                    if(seccion.get(i).getSeccion()==estudiante.getSeccion())
                        jlist1.setSelectedIndex(i);
            }
        }
    }

    public void actualizarJTextField() {
        if(jlist1.getSelectedIndex()!=-1)
            jtextfield[4].setText(jlist1.getSelectedValue().toString());
    }
 
    
    public boolean getEditing(){
        return editing;
    }

    public ButtonAction getButtonIngresar() {
        return jbutton[0];
    }
    
}
