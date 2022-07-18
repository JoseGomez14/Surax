/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.vista;

import co.edu.udea.surax.control.PersonaControl;
import co.edu.udea.surax.modelo.JuridicaModelo;
import co.edu.udea.surax.modelo.NaturalModelo;
import co.edu.udea.surax.modelo.PersonaModelo;
import co.edu.udea.surax.modelo.Utils;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 * 
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 * 
 */
public class PersonaVista extends javax.swing.JFrame {
    
    PersonaControl controladorDePersona;
    Color colorError = new Color(255, 180, 180);
    Color colorBlanco = new Color(255, 255, 255);
    ArrayList<String> listaOcupaciones = new ArrayList<String>();
    String[] arrOcupaciones;
    
    
    /**
     * Creates new form PersonaVista
     */
    public PersonaVista(ArrayList<Object> data){
        try {
            this.listaOcupaciones = Utils.leerCsv("Profesiones.csv");
            this.arrOcupaciones = new String[listaOcupaciones.size()];
            for(int i = 0; i < arrOcupaciones.length; i++){
                String aux = listaOcupaciones.get(i);
                arrOcupaciones[i] = aux.split(";")[0];
            }
        } catch (IOException e) {
            msjIndicacion.setText("Ocurrió un error al cargar las profesiones");
        }
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/icon.png")).getImage());
        setTitle("Surax");
        
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        cambiarANatural();
        
        controladorDePersona = new PersonaControl(data);
    }

    private PersonaVista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void agregarNaturalVista() throws IOException{
        if(comprobarFormularioNatural()){             
                String nivEducativo = "Ninguno";
                
                if(inputRdPrimaria.isSelected()){
                    nivEducativo = "Primaria";
                }else if(inputRdSecundaria.isSelected()){
                    nivEducativo = "Secundaria";
                }else if(inputRdPregrado.isSelected()){
                    nivEducativo = "Pregrado";
                }
                
                char sexo = 'F';
                if(inputOptionSexo.getSelectedItem() == "Hombre"){
                    sexo = 'M';
                }
                controladorDePersona.crearPersona(inputNombre.getText(), 
                        Long.parseLong(inputId.getText()), Long.parseLong(inputTel.getText()),
                        crearDir(), inputEmail.getText(), 
                        sexo, "Hola", 
                        inputCheckBoxDiscapacidad.isSelected(), (String)inputOptionOcupacion.getSelectedItem(), 
                        (short) inputNumEstrato.getValue(), (String)inputOptionEstadoCivil.getSelectedItem(), nivEducativo, 
                        (short) inputNumEdad.getValue(), Short.parseShort("0"),
                        Short.parseShort("0"), Short.parseShort("0"));
                msjIndicacion.setText(inputNombre.getText() + " se agregó correctamente");
                limpiarVetana();
                }else{
                msjIndicacion.setText("Debes ingresar información valida en los campos");
            }
    }
    
    public void agregarJuridicaVista(){
        if(comprobarFormularioJuridica()){
                controladorDePersona.crearPersona(inputNombre.getText(), Long.parseLong(inputId.getText()),
                        Long.parseLong(inputTel.getText()), crearDir(),
                        inputEmail.getText(), inputActividad.getText()
                        , (String)inputOptionSector.getSelectedItem());
                msjIndicacion.setText(inputNombre.getText() + " se agregó correctamente");
                limpiarVetana();
            }else{
                msjIndicacion.setText("Debes ingresar información valida en los campos");
            }
    }
    
    public void agregarPersonaVista() throws IOException{
        if(Utils.comprobarTexto(inputId.getText(), "^\\d{7,10}$")){
            if(!controladorDePersona.personaExistente(Long.parseLong(inputId.getText()))){
                if(inputRdNatural.isSelected()){
                    agregarNaturalVista();
                }
                else{
                    agregarJuridicaVista();
                }
            }else{
                msjIndicacion.setText("La persona ya se encuentra registrada.");
            }
        }else{
            if(inputRdNatural.isSelected()){
                comprobarFormularioNatural();
            }else{comprobarFormularioJuridica();}
        }
    }
    
    public void eliminarPersonaVista(){
        String msj = "";
        if(controladorDePersona.eliminarPersona(Long.parseLong(inputId.getText()))){
                msj = "Se eliminó correctamente la persona identificada con: " + inputId.getText();
                limpiarVetana();
        }else{
            msj = "No se pudo eliminar el registro, revise el documento";
        }
        msjIndicacion.setText(msj);
    }
    
    public void actualizarPersonaVista() throws IOException{
        if(inputRdNatural.isSelected()){
            if(comprobarFormularioNatural()){             
                String nivEducativo = "Ninguno";
                
                if(inputRdPrimaria.isSelected()){
                    nivEducativo = "Primaria";
                }else if(inputRdSecundaria.isSelected()){
                    nivEducativo = "Secundaria";
                }else if(inputRdPregrado.isSelected()){
                    nivEducativo = "Pregrado";
                }
                
                char sexo = 'F';
                if(inputOptionSexo.getSelectedItem() == "Hombre"){
                    sexo = 'M';
                }
                
                controladorDePersona.actPersona(inputNombre.getText(), 
                        Long.parseLong(inputId.getText()), Long.parseLong(inputTel.getText()),
                        crearDir(), inputEmail.getText(), 
                        sexo, "Hola", 
                        inputCheckBoxDiscapacidad.isSelected(), (String)inputOptionOcupacion.getSelectedItem(),
                        (short) inputNumEstrato.getValue(), (String)inputOptionEstadoCivil.getSelectedItem(), nivEducativo, 
                        (short) inputNumEdad.getValue(), Short.parseShort("0"),
                        Short.parseShort("0"), Short.parseShort("0"));
                msjIndicacion.setText(inputNombre.getText() + " se actualizó correctamente");
                limpiarVetana();
            }else{
                msjIndicacion.setText("Debes ingresar información valida en los campos");
            }
        }else{
            if(comprobarFormularioJuridica()){
                controladorDePersona.actPersona(inputNombre.getText(), Long.parseLong(inputId.getText()),
                        Long.parseLong(inputTel.getText()), crearDir(),
                        inputEmail.getText(), inputActividad.getText()
                        , (String)inputOptionSector.getSelectedItem());
                msjIndicacion.setText(inputNombre.getText() + " se actualizó correctamente");
                limpiarVetana();
            }else{
                msjIndicacion.setText("Debes ingresar información valida en los campos");
            }
        }
    }
    
    public void buscarNaturalVista(NaturalModelo naturalModelo) {
        if (naturalModelo.getSexo() == 'M') {
            inputOptionSexo.setSelectedItem("Hombre");
        } else {
            inputOptionSexo.setSelectedItem("Mujer");
        }

        inputNumEdad.setValue(naturalModelo.getEdad());
        inputNumEstrato.setValue(naturalModelo.getEstrato());

        if (naturalModelo.getDiscapacidad()) {
            inputCheckBoxDiscapacidad.setSelected(true);
        }
        
        inputOptionEstadoCivil.setSelectedItem(naturalModelo.getEstadoCivil());

        if ("Primaria".equals(naturalModelo.getNivelEducativo())) {
            inputRdPrimaria.setSelected(true);
        } else if ("Secundaria".equals(naturalModelo.getNivelEducativo())) {
            inputRdPrimaria.setSelected(true);
        } else if ("Pregrado".equals(naturalModelo.getNivelEducativo())) {
            inputRdPrimaria.setSelected(true);
        }
        
    }
    
    public void buscarPersonaVista(){
        PersonaModelo personaBuscada = controladorDePersona.leerPersona(Long.parseLong(inputId.getText()));
    
       if(personaBuscada != null){
           if(personaBuscada instanceof NaturalModelo){
                NaturalModelo naturalModelo = (NaturalModelo)personaBuscada;
                buscarNaturalVista(naturalModelo);
                cambiarANatural();
                System.out.println(naturalModelo);
            }else if(personaBuscada instanceof JuridicaModelo){
                JuridicaModelo juridicaModelo = (JuridicaModelo)personaBuscada;       
                inputActividad.setText(juridicaModelo.getActividadPrincipal());
                inputOptionSector.setSelectedItem(((JuridicaModelo) personaBuscada).getSector());
                cambiarAJuridica();
            }
            
            inputTel.setText(String.valueOf(personaBuscada.getTel()));
            inputNombre.setText(personaBuscada.getNombre());
            inputId.setText(String.valueOf(personaBuscada.getId()));
            inputEmail.setText(personaBuscada.getCorreo());
            leerDir(personaBuscada.getDireccion());
           
           btnActualizaInfo.setEnabled(true);
       }else{
           msjIndicacion.setText("La persona buscada no se encuentra en la base de datos.");
       }
    }
    
    public void limpiarVetana(){
        Utils.limpiarCampos(jPanelIzq);
        Utils.limpiarCampos(jPanelDer);
        Utils.limpiarCampos(jPanelDir);
        Utils.limpiarCampos(jPanelEnf);
        Utils.limpiarCampos(jPanelInfoPer);
        Utils.limpiarCampos(jPanelInfoPer2);
        Utils.limpiarCampos(jPanelInfoPer3);
        btnBuscarPersona.setEnabled(false);
        btnEliminarPersona.setEnabled(false);
        btnActualizaInfo.setEnabled(false);
    }
    
    public void compTxtFld(JTextField input, String expresion){
        if(Utils.comprobarTexto(input.getText(), expresion)){
            input.setBackground(colorBlanco);
        }else{input.setBackground(colorError);}
    }
    
    public boolean comprobarFormulario(){
        compTxtFld(inputNombre, "^[a-zA-ZÀ-ÿ\\s]{1,80}$");
        compTxtFld(inputId, "^\\d{7,10}$");
        compTxtFld(inputEmail, "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        compTxtFld(inputTel, "^\\d{7,10}$");
        
        if(!"".equals(inputDir.getText())){
            inputDir.setBackground(colorBlanco);
        }else{inputDir.setBackground(colorError);}
        
        if(idxDtpoSelect != 0){
            inputOptionDpto.setBackground(colorBlanco);
        }else{inputOptionDpto.setBackground(colorError);}
        
        if(idxMpioSelect != 0){
            inputOptionMpio.setBackground(colorBlanco);
        }else{inputOptionMpio.setBackground(colorError);}
        
        return Utils.comprobarTexto(inputNombre.getText(), "^[a-zA-ZÀ-ÿ\\s]{1,80}$")
                && Utils.comprobarTexto(inputId.getText(), "^\\d{7,10}$")
                && Utils.comprobarTexto(inputEmail.getText(), "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
                && Utils.comprobarTexto(inputTel.getText(), "^\\d{7,10}$")
                && !"".equals(inputDir.getText())
                && idxDtpoSelect != 0 && idxMpioSelect != 0;
    }
    
    public boolean comprobarFormularioNatural(){
        if(inputOptionSexo.getSelectedItem() != "Seleccione un sexo"){
            inputOptionSexo.setBackground(colorBlanco);
        }else{inputOptionSexo.setBackground(colorError);}
        
        if(inputOptionEstadoCivil.getSelectedItem() != "Seleccione un estado civil"){
            inputOptionEstadoCivil.setBackground(colorBlanco);
        }else{inputOptionEstadoCivil.setBackground(colorError);}
        
        return comprobarFormulario()
                && inputOptionSexo.getSelectedItem() != "Seleccione un sexo"
                && inputOptionEstadoCivil.getSelectedItem() != "Seleccione un estado civil";
    }
    
    public boolean comprobarFormularioJuridica(){
        compTxtFld(inputActividad, "^[a-zA-ZÀ-ÿ\\s]{1,40}$");
        
        if(inputOptionEstadoCivil.getSelectedItem() != "Seleccione un estado civil"){
            inputOptionEstadoCivil.setBackground(colorBlanco);
        }else{inputOptionEstadoCivil.setBackground(colorError);}
        
        if(inputOptionSector.getSelectedItem() != "Seleccione un sector"){
            inputOptionSector.setBackground(colorBlanco);
        }else{inputOptionSector.setBackground(colorError);}
        
        return comprobarFormulario()
                && Utils.comprobarTexto(inputActividad.getText(), "^[a-zA-ZÀ-ÿ\\s]{1,40}$")
                && inputOptionSector.getSelectedItem() != "Seleccione un sector";
    }
    
    public ArrayList<String> crearDir(){
        ArrayList<String> result = new ArrayList<String>();
        result.add("Colombia");
        result.add(listDptos[idxDtpoSelect]);
        result.add(listMpios[idxMpioSelect]);
        result.add(inputRdUrbana.isSelected()? "Urbano": "Rural");
        result.add(inputDir.getText());
        result.add(inputCodPostal.getText());
        
        return result;
    }
    
    public void leerDir(ArrayList<String> direccion){
        inputOptionDpto.setSelectedItem(direccion.get(1));
        inputOptionMpio.setSelectedItem(direccion.get(2));
        if("Rural".equals(direccion.get(3))){
            inputRdRural.setSelected(true);
            inputRdUrbana.setSelected(false);
        }else{
            inputRdRural.setSelected(false);
            inputRdUrbana.setSelected(true);
        }
        inputDir.setText(direccion.get(4));
        inputCodPostal.setText(direccion.get(5));
        idxDtpoSelect = inputOptionDpto.getSelectedIndex();
        idxMpioSelect = inputOptionMpio.getSelectedIndex();
    }
    
    public void cambiarANatural(){
        jPanelEnf.setVisible(true);
        jPanelInfoPer2.setVisible(true);
        jPanelInfoPer3.setVisible(false);
        inputRdNatural.setSelected(true);
        inputRdJuridica.setSelected(false);
        inputNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax
                .swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), 
                "Nombre Completo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder
                .DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112)));
        inputId.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory
                .createLineBorder(new java.awt.Color(112, 112, 112), 2), "Número de Documento",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder
                .DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112)));
    }
    
    public void cambiarAJuridica(){
        jPanelEnf.setVisible(false);
        jPanelInfoPer2.setVisible(false);
        jPanelInfoPer3.setVisible(true);
        inputRdNatural.setSelected(false);
        inputRdJuridica.setSelected(true);
        inputNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory
                .createLineBorder(new java.awt.Color(112, 112, 112), 2), "Razón Social",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112)));
        inputId.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory
                .createLineBorder(new java.awt.Color(112, 112, 112), 2), "NIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112)));
    }
        
    int idxDtpoSelect = 0;
    int idxMpioSelect = 0;
    Utils utils = new Utils();
    String[] listDptos = utils.getDEPARTAMENTOS();
    String[] listMpios = utils.getMUNICIPIOS()[idxDtpoSelect];
       
    DefaultComboBoxModel optionsCbxModelDptos;
    DefaultComboBoxModel optionsCbxModelMpios;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipoPersona = new javax.swing.ButtonGroup();
        btnGroupZona = new javax.swing.ButtonGroup();
        btnGroupNivelAdco = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JLabel();
        btnAgregarPersona = new javax.swing.JLabel();
        btnBuscarPersona = new javax.swing.JLabel();
        btnEliminarPersona = new javax.swing.JLabel();
        btnLimpiarVentana = new javax.swing.JLabel();
        msjIndicacion = new javax.swing.JLabel();
        btnActualizaInfo = new javax.swing.JLabel();
        btnCotizarPoliza = new javax.swing.JLabel();
        jPanelIzq = new javax.swing.JPanel();
        jPanelInfoPer = new javax.swing.JPanel();
        inputTel = new javax.swing.JTextField();
        inputEmail = new javax.swing.JTextField();
        inputId = new javax.swing.JTextField();
        inputNombre = new javax.swing.JTextField();
        labelInfoPersonal1 = new javax.swing.JLabel();
        inputRdNatural = new javax.swing.JRadioButton();
        inputRdJuridica = new javax.swing.JRadioButton();
        labelTipoPersona = new javax.swing.JLabel();
        jPanelInfoPer2 = new javax.swing.JPanel();
        inputOptionSexo = new javax.swing.JComboBox<>();
        inputNumEdad = new javax.swing.JSpinner();
        inputNumEstrato = new javax.swing.JSpinner();
        inputOptionEstadoCivil = new javax.swing.JComboBox<>();
        inputCheckBoxDiscapacidad = new javax.swing.JCheckBox();
        inputOptionOcupacion = new javax.swing.JComboBox<>();
        jPanelInfoPer3 = new javax.swing.JPanel();
        inputActividad = new javax.swing.JTextField();
        inputOptionSector = new javax.swing.JComboBox<>();
        jPanelDer = new javax.swing.JPanel();
        jPanelEnf = new javax.swing.JPanel();
        labelInfoPersonal4 = new javax.swing.JLabel();
        inputRdPrimaria = new javax.swing.JRadioButton();
        inputRdSecundaria = new javax.swing.JRadioButton();
        inputRdPregrado = new javax.swing.JRadioButton();
        labelTipoPersona1 = new javax.swing.JLabel();
        inputCheckBoxEnf1 = new javax.swing.JCheckBox();
        inputCheckBoxEnf2 = new javax.swing.JCheckBox();
        inputCheckBoxEnf3 = new javax.swing.JCheckBox();
        inputCheckBoxEnf4 = new javax.swing.JCheckBox();
        inputCheckBoxEnf5 = new javax.swing.JCheckBox();
        inputCheckBoxEnf6 = new javax.swing.JCheckBox();
        inputCheckBoxEnf7 = new javax.swing.JCheckBox();
        inputCheckBoxEnf8 = new javax.swing.JCheckBox();
        inputCheckBoxEnf9 = new javax.swing.JCheckBox();
        inputCheckBoxEnf10 = new javax.swing.JCheckBox();
        inputCheckBoxEnf11 = new javax.swing.JCheckBox();
        inputCheckBoxEnf12 = new javax.swing.JCheckBox();
        jPanelDir = new javax.swing.JPanel();
        labelDir = new javax.swing.JLabel();
        inputOptionDpto = new javax.swing.JComboBox<>();
        inputOptionMpio = new javax.swing.JComboBox<>();
        inputDir = new javax.swing.JTextField();
        inputCodPostal = new javax.swing.JTextField();
        labelZona = new javax.swing.JLabel();
        inputRdUrbana = new javax.swing.JRadioButton();
        inputRdRural = new javax.swing.JRadioButton();
        jSeparator = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setAutoscrolls(true);
        jPanel5.setPreferredSize(new java.awt.Dimension(1280, 950));
        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/back_icon.png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        btnVolver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnVolverKeyPressed(evt);
            }
        });
        jPanel5.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 32, -1, 54));

        btnAgregarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/agregar_persona.png"))); // NOI18N
        btnAgregarPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarPersona.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/agregar_persona_disabled.png"))); // NOI18N
        btnAgregarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarPersonaMouseClicked(evt);
            }
        });
        jPanel5.add(btnAgregarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 32, -1, -1));

        btnBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/buscar_persona.png"))); // NOI18N
        btnBuscarPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarPersona.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/buscar_persona_disabled.png"))); // NOI18N
        btnBuscarPersona.setEnabled(false);
        btnBuscarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPersonaMouseClicked(evt);
            }
        });
        jPanel5.add(btnBuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 32, -1, -1));

        btnEliminarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/eliminar_persona.png"))); // NOI18N
        btnEliminarPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarPersona.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/eliminar_persona_disabled.png"))); // NOI18N
        btnEliminarPersona.setEnabled(false);
        btnEliminarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarPersonaMouseClicked(evt);
            }
        });
        jPanel5.add(btnEliminarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 32, -1, -1));

        btnLimpiarVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/trash_icon.png"))); // NOI18N
        btnLimpiarVentana.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarVentana.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/trash_icon_disabled.png"))); // NOI18N
        btnLimpiarVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarVentanaMouseClicked(evt);
            }
        });
        jPanel5.add(btnLimpiarVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(1206, 32, -1, 54));

        msjIndicacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        msjIndicacion.setForeground(new java.awt.Color(112, 112, 112));
        msjIndicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msjIndicacion.setText("   -");
        jPanel5.add(msjIndicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 1280, 40));

        btnActualizaInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/act_informacion.png"))); // NOI18N
        btnActualizaInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizaInfo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/act_informacion_disabled.png"))); // NOI18N
        btnActualizaInfo.setEnabled(false);
        btnActualizaInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizaInfoMouseClicked(evt);
            }
        });
        jPanel5.add(btnActualizaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 860, -1, -1));

        btnCotizarPoliza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/cotizar_poliza.png"))); // NOI18N
        btnCotizarPoliza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCotizarPoliza.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/surax/vista/images/cotizar_poliza_disabled.png"))); // NOI18N
        btnCotizarPoliza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCotizarPolizaMouseClicked(evt);
            }
        });
        jPanel5.add(btnCotizarPoliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 860, -1, -1));

        jPanelIzq.setBackground(java.awt.Color.white);
        jPanelIzq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInfoPer.setBackground(java.awt.Color.white);

        inputTel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputTel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Número de Teléfono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputTel.setVerifyInputWhenFocusTarget(false);
        inputTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTelActionPerformed(evt);
            }
        });

        inputEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Correo Electrónico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputEmail.setVerifyInputWhenFocusTarget(false);
        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        inputId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputId.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Número de Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputId.setVerifyInputWhenFocusTarget(false);
        inputId.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputIdInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });
        inputId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputIdKeyTyped(evt);
            }
        });

        inputNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Nombre Completo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputNombre.setVerifyInputWhenFocusTarget(false);
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });

        labelInfoPersonal1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelInfoPersonal1.setForeground(new java.awt.Color(0, 163, 224));
        labelInfoPersonal1.setText("Información Personal*");

        inputRdNatural.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupTipoPersona.add(inputRdNatural);
        inputRdNatural.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdNatural.setText("Natural");
        inputRdNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdNaturalActionPerformed(evt);
            }
        });

        inputRdJuridica.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupTipoPersona.add(inputRdJuridica);
        inputRdJuridica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdJuridica.setText("Jurídica");
        inputRdJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdJuridicaActionPerformed(evt);
            }
        });

        labelTipoPersona.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTipoPersona.setForeground(new java.awt.Color(0, 163, 224));
        labelTipoPersona.setText("Tipo de persona");

        javax.swing.GroupLayout jPanelInfoPerLayout = new javax.swing.GroupLayout(jPanelInfoPer);
        jPanelInfoPer.setLayout(jPanelInfoPerLayout);
        jPanelInfoPerLayout.setHorizontalGroup(
            jPanelInfoPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelInfoPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoPerLayout.createSequentialGroup()
                        .addGroup(jPanelInfoPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelInfoPerLayout.createSequentialGroup()
                                .addComponent(inputRdNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputRdJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelTipoPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(154, 154, 154))
                    .addComponent(labelInfoPersonal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputId)
                    .addComponent(inputEmail)
                    .addComponent(inputTel)
                    .addComponent(inputNombre))
                .addGap(0, 0, 0))
        );
        jPanelInfoPerLayout.setVerticalGroup(
            jPanelInfoPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelTipoPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRdNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRdJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfoPersonal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputTel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanelIzq.add(jPanelInfoPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 0, -1, -1));

        jPanelInfoPer2.setBackground(java.awt.Color.white);

        inputOptionSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un sexo", "Hombre", "Mujer" }));
        inputOptionSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOptionSexoActionPerformed(evt);
            }
        });

        inputNumEdad.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)120), Short.valueOf((short)1)));
        inputNumEdad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Edad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputNumEdad.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        inputNumEstrato.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)0), Short.valueOf((short)0), Short.valueOf((short)6), Short.valueOf((short)1)));
        inputNumEstrato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Estrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputNumEstrato.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        inputOptionEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un estado civil", "Soltero/a", "Casado/a", "Viudo/a", "Divorciado/a", "En unión libre" }));

        inputCheckBoxDiscapacidad.setBackground(java.awt.Color.white);
        inputCheckBoxDiscapacidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputCheckBoxDiscapacidad.setText("Discapacidad");

        inputOptionOcupacion.setModel(new javax.swing.DefaultComboBoxModel<>(arrOcupaciones));
        inputOptionOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOptionOcupacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInfoPer2Layout = new javax.swing.GroupLayout(jPanelInfoPer2);
        jPanelInfoPer2.setLayout(jPanelInfoPer2Layout);
        jPanelInfoPer2Layout.setHorizontalGroup(
            jPanelInfoPer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPer2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelInfoPer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoPer2Layout.createSequentialGroup()
                        .addComponent(inputCheckBoxDiscapacidad)
                        .addContainerGap())
                    .addGroup(jPanelInfoPer2Layout.createSequentialGroup()
                        .addComponent(inputNumEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNumEstrato))
                    .addComponent(inputOptionEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputOptionSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputOptionOcupacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelInfoPer2Layout.setVerticalGroup(
            jPanelInfoPer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPer2Layout.createSequentialGroup()
                .addComponent(inputOptionOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputOptionSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoPer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNumEstrato, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNumEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputOptionEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputCheckBoxDiscapacidad)
                .addContainerGap())
        );

        jPanelIzq.add(jPanelInfoPer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 440, -1));

        jPanelInfoPer3.setBackground(java.awt.Color.white);

        inputActividad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputActividad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Actividad Principal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputActividad.setVerifyInputWhenFocusTarget(false);
        inputActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActividadActionPerformed(evt);
            }
        });

        inputOptionSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un sector", "Agropecuario", "Comercio exterior", "Comercio y servicios", "Construcción", "Industria", "Precios", "Economía Regional", "Educacion", "Tecnologías de información", "Agropecuario", "Industria", "Indicadores de competitividad", "Educacion" }));

        javax.swing.GroupLayout jPanelInfoPer3Layout = new javax.swing.GroupLayout(jPanelInfoPer3);
        jPanelInfoPer3.setLayout(jPanelInfoPer3Layout);
        jPanelInfoPer3Layout.setHorizontalGroup(
            jPanelInfoPer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPer3Layout.createSequentialGroup()
                .addGroup(jPanelInfoPer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputActividad)
                    .addComponent(inputOptionSector, 0, 440, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanelInfoPer3Layout.setVerticalGroup(
            jPanelInfoPer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPer3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(inputActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputOptionSector, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanelIzq.add(jPanelInfoPer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        jPanel5.add(jPanelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 148, 590, -1));

        jPanelDer.setBackground(java.awt.Color.white);

        jPanelEnf.setBackground(java.awt.Color.white);

        labelInfoPersonal4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelInfoPersonal4.setForeground(new java.awt.Color(0, 163, 224));
        labelInfoPersonal4.setText("Nivel Académico");

        inputRdPrimaria.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupNivelAdco.add(inputRdPrimaria);
        inputRdPrimaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdPrimaria.setText("Primaria");
        inputRdPrimaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdPrimariaActionPerformed(evt);
            }
        });

        inputRdSecundaria.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupNivelAdco.add(inputRdSecundaria);
        inputRdSecundaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdSecundaria.setText("Secundaria");
        inputRdSecundaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdSecundariaActionPerformed(evt);
            }
        });

        inputRdPregrado.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupNivelAdco.add(inputRdPregrado);
        inputRdPregrado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdPregrado.setText("Pregrado");
        inputRdPregrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdPregradoActionPerformed(evt);
            }
        });

        labelTipoPersona1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTipoPersona1.setForeground(new java.awt.Color(0, 163, 224));
        labelTipoPersona1.setText("Enfermedades");

        inputCheckBoxEnf1.setBackground(java.awt.Color.white);
        inputCheckBoxEnf1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf1.setText("Diabetes I");

        inputCheckBoxEnf2.setBackground(java.awt.Color.white);
        inputCheckBoxEnf2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf2.setText("Diabetes II");
        inputCheckBoxEnf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf2ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf3.setBackground(java.awt.Color.white);
        inputCheckBoxEnf3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf3.setText("Enfermedad leve");
        inputCheckBoxEnf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf3ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf4.setBackground(java.awt.Color.white);
        inputCheckBoxEnf4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf4.setText("Demencia");
        inputCheckBoxEnf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf4ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf5.setBackground(java.awt.Color.white);
        inputCheckBoxEnf5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf5.setText("Hipertensión");
        inputCheckBoxEnf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf5ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf6.setBackground(java.awt.Color.white);
        inputCheckBoxEnf6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf6.setText("Enfermedad grave");
        inputCheckBoxEnf6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf6ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf7.setBackground(java.awt.Color.white);
        inputCheckBoxEnf7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf7.setText("Cardiopatía isquémica");

        inputCheckBoxEnf8.setBackground(java.awt.Color.white);
        inputCheckBoxEnf8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf8.setText("Enfermedad medianamente grave");
        inputCheckBoxEnf8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf8ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf9.setBackground(java.awt.Color.white);
        inputCheckBoxEnf9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf9.setText("Antecedente cerebrovacular");

        inputCheckBoxEnf10.setBackground(java.awt.Color.white);
        inputCheckBoxEnf10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf10.setText("Enfermedad pulmonar");
        inputCheckBoxEnf10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf10ActionPerformed(evt);
            }
        });

        inputCheckBoxEnf11.setBackground(java.awt.Color.white);
        inputCheckBoxEnf11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf11.setText("Cancer de colon");

        inputCheckBoxEnf12.setBackground(java.awt.Color.white);
        inputCheckBoxEnf12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCheckBoxEnf12.setText("Cáncer de pulmón");
        inputCheckBoxEnf12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCheckBoxEnf12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEnfLayout = new javax.swing.GroupLayout(jPanelEnf);
        jPanelEnf.setLayout(jPanelEnfLayout);
        jPanelEnfLayout.setHorizontalGroup(
            jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnfLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelEnfLayout.createSequentialGroup()
                            .addComponent(inputCheckBoxEnf7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputCheckBoxEnf8))
                        .addGroup(jPanelEnfLayout.createSequentialGroup()
                            .addComponent(inputCheckBoxEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputCheckBoxEnf2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputCheckBoxEnf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanelEnfLayout.createSequentialGroup()
                            .addComponent(inputRdPrimaria, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(inputRdSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(inputRdPregrado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelInfoPersonal4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTipoPersona1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelEnfLayout.createSequentialGroup()
                            .addComponent(inputCheckBoxEnf4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputCheckBoxEnf5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputCheckBoxEnf6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEnfLayout.createSequentialGroup()
                        .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputCheckBoxEnf11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputCheckBoxEnf9, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnfLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputCheckBoxEnf10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnfLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputCheckBoxEnf12, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0))
        );
        jPanelEnfLayout.setVerticalGroup(
            jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnfLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelTipoPersona1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCheckBoxEnf1)
                    .addComponent(inputCheckBoxEnf2)
                    .addComponent(inputCheckBoxEnf3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCheckBoxEnf4)
                    .addComponent(inputCheckBoxEnf5)
                    .addComponent(inputCheckBoxEnf6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCheckBoxEnf7)
                    .addComponent(inputCheckBoxEnf8))
                .addGap(8, 8, 8)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCheckBoxEnf9)
                    .addComponent(inputCheckBoxEnf10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCheckBoxEnf11)
                    .addComponent(inputCheckBoxEnf12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelInfoPersonal4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRdPrimaria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRdSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRdPregrado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanelDir.setBackground(java.awt.Color.white);

        labelDir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelDir.setForeground(new java.awt.Color(0, 163, 224));
        labelDir.setText("Dirección*");

        inputOptionDpto.setModel(new javax.swing.DefaultComboBoxModel<>(listDptos));
        inputOptionDpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOptionDptoActionPerformed(evt);
            }
        });

        inputOptionMpio.setModel(new javax.swing.DefaultComboBoxModel<>(listMpios));
        inputOptionMpio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOptionMpioActionPerformed(evt);
            }
        });

        inputDir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputDir.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputDir.setVerifyInputWhenFocusTarget(false);
        inputDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDirinputNombreActionPerformed(evt);
            }
        });

        inputCodPostal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputCodPostal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 2), "Código Postal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        inputCodPostal.setVerifyInputWhenFocusTarget(false);
        inputCodPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCodPostalinputNombreActionPerformed(evt);
            }
        });

        labelZona.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelZona.setForeground(new java.awt.Color(0, 163, 224));
        labelZona.setText("Zona");

        inputRdUrbana.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupZona.add(inputRdUrbana);
        inputRdUrbana.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdUrbana.setText("Urbana");
        inputRdUrbana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdUrbanaActionPerformed(evt);
            }
        });

        inputRdRural.setBackground(new java.awt.Color(230, 246, 252));
        btnGroupZona.add(inputRdRural);
        inputRdRural.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputRdRural.setText("Rural");
        inputRdRural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRdRuralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDirLayout = new javax.swing.GroupLayout(jPanelDir);
        jPanelDir.setLayout(jPanelDirLayout);
        jPanelDirLayout.setHorizontalGroup(
            jPanelDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDirLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputOptionDpto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDirLayout.createSequentialGroup()
                        .addGroup(jPanelDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelDirLayout.createSequentialGroup()
                                    .addComponent(inputRdUrbana, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(inputRdRural, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(labelZona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(inputOptionMpio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputDir)
                    .addComponent(inputCodPostal)))
        );
        jPanelDirLayout.setVerticalGroup(
            jPanelDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDirLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputOptionDpto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputOptionMpio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelZona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRdUrbana, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRdRural, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanelDerLayout = new javax.swing.GroupLayout(jPanelDer);
        jPanelDer.setLayout(jPanelDerLayout);
        jPanelDerLayout.setHorizontalGroup(
            jPanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDerLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDerLayout.setVerticalGroup(
            jPanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEnf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanelDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanelDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 148, 540, -1));

        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, 638));

        jScrollPane1.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5KeyPressed

    private void inputRdRuralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdRuralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRdRuralActionPerformed

    private void inputRdUrbanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdUrbanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRdUrbanaActionPerformed

    private void inputCodPostalinputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCodPostalinputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCodPostalinputNombreActionPerformed

    private void inputDirinputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDirinputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDirinputNombreActionPerformed

    private void inputOptionMpioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptionMpioActionPerformed
        idxMpioSelect = utils.buscarEnStringArray(listMpios, (String) inputOptionMpio.getSelectedItem());
    }//GEN-LAST:event_inputOptionMpioActionPerformed

    private void inputOptionDptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptionDptoActionPerformed
        idxDtpoSelect = utils.buscarEnStringArray(listDptos, (String) inputOptionDpto.getSelectedItem());
        listMpios = utils.getMUNICIPIOS()[idxDtpoSelect];
        DefaultComboBoxModel styleCbxModelMpios = new javax.swing.DefaultComboBoxModel<>(listMpios);
        inputOptionMpio.setModel(styleCbxModelMpios);
    }//GEN-LAST:event_inputOptionDptoActionPerformed

    private void inputCheckBoxEnf12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf12ActionPerformed

    private void inputCheckBoxEnf10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf10ActionPerformed

    private void inputCheckBoxEnf8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf8ActionPerformed

    private void inputCheckBoxEnf6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf6ActionPerformed

    private void inputCheckBoxEnf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf5ActionPerformed

    private void inputCheckBoxEnf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf4ActionPerformed

    private void inputCheckBoxEnf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf3ActionPerformed

    private void inputCheckBoxEnf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCheckBoxEnf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCheckBoxEnf2ActionPerformed

    private void inputRdPregradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdPregradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRdPregradoActionPerformed

    private void inputRdSecundariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdSecundariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRdSecundariaActionPerformed

    private void inputRdPrimariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdPrimariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRdPrimariaActionPerformed

    private void inputActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActividadActionPerformed

    private void inputOptionOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptionOcupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputOptionOcupacionActionPerformed

    private void inputOptionSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptionSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputOptionSexoActionPerformed

    private void inputRdJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdJuridicaActionPerformed
        cambiarAJuridica();
    }//GEN-LAST:event_inputRdJuridicaActionPerformed

    private void inputRdNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRdNaturalActionPerformed
        cambiarANatural();
    }//GEN-LAST:event_inputRdNaturalActionPerformed

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

    private void inputIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputIdKeyTyped
        if(Utils.comprobarTexto(inputId.getText(), "^\\d{7,10}$")){
            btnBuscarPersona.setEnabled(true);
            btnEliminarPersona.setEnabled(true);
        }else{
            btnBuscarPersona.setEnabled(false);
            btnEliminarPersona.setEnabled(false);
        }
    }//GEN-LAST:event_inputIdKeyTyped

    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void inputIdInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputIdInputMethodTextChanged

    }//GEN-LAST:event_inputIdInputMethodTextChanged

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void inputTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTelActionPerformed

    private void btnActualizaInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizaInfoMouseClicked
        try {
            actualizarPersonaVista();
        } catch (IOException ex) {
            Logger.getLogger(PersonaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizaInfoMouseClicked

    private void btnLimpiarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarVentanaMouseClicked
        limpiarVetana();
    }//GEN-LAST:event_btnLimpiarVentanaMouseClicked

    private void btnEliminarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPersonaMouseClicked
        eliminarPersonaVista();
    }//GEN-LAST:event_btnEliminarPersonaMouseClicked

    private void btnBuscarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPersonaMouseClicked
        buscarPersonaVista();
    }//GEN-LAST:event_btnBuscarPersonaMouseClicked

    private void btnAgregarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPersonaMouseClicked
        try {
            agregarPersonaVista();
        } catch (IOException ex) {
            Logger.getLogger(PersonaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarPersonaMouseClicked

    private void btnVolverKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVolverKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverKeyPressed

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        Utils.pasarFrame(this, new Surax(controladorDePersona.getData()));
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnCotizarPolizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCotizarPolizaMouseClicked
        Utils.pasarFrame(this, new PolizaVista(controladorDePersona.getData()));
    }//GEN-LAST:event_btnCotizarPolizaMouseClicked

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
            java.util.logging.Logger.getLogger(PersonaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizaInfo;
    private javax.swing.JLabel btnAgregarPersona;
    private javax.swing.JLabel btnBuscarPersona;
    private javax.swing.JLabel btnCotizarPoliza;
    private javax.swing.JLabel btnEliminarPersona;
    private javax.swing.ButtonGroup btnGroupNivelAdco;
    private javax.swing.ButtonGroup btnGroupTipoPersona;
    private javax.swing.ButtonGroup btnGroupZona;
    private javax.swing.JLabel btnLimpiarVentana;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JTextField inputActividad;
    private javax.swing.JCheckBox inputCheckBoxDiscapacidad;
    private javax.swing.JCheckBox inputCheckBoxEnf1;
    private javax.swing.JCheckBox inputCheckBoxEnf10;
    private javax.swing.JCheckBox inputCheckBoxEnf11;
    private javax.swing.JCheckBox inputCheckBoxEnf12;
    private javax.swing.JCheckBox inputCheckBoxEnf2;
    private javax.swing.JCheckBox inputCheckBoxEnf3;
    private javax.swing.JCheckBox inputCheckBoxEnf4;
    private javax.swing.JCheckBox inputCheckBoxEnf5;
    private javax.swing.JCheckBox inputCheckBoxEnf6;
    private javax.swing.JCheckBox inputCheckBoxEnf7;
    private javax.swing.JCheckBox inputCheckBoxEnf8;
    private javax.swing.JCheckBox inputCheckBoxEnf9;
    private javax.swing.JTextField inputCodPostal;
    private javax.swing.JTextField inputDir;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JSpinner inputNumEdad;
    private javax.swing.JSpinner inputNumEstrato;
    private javax.swing.JComboBox<String> inputOptionDpto;
    private javax.swing.JComboBox<String> inputOptionEstadoCivil;
    private javax.swing.JComboBox<String> inputOptionMpio;
    private javax.swing.JComboBox<String> inputOptionOcupacion;
    private javax.swing.JComboBox<String> inputOptionSector;
    private javax.swing.JComboBox<String> inputOptionSexo;
    private javax.swing.JRadioButton inputRdJuridica;
    private javax.swing.JRadioButton inputRdNatural;
    private javax.swing.JRadioButton inputRdPregrado;
    private javax.swing.JRadioButton inputRdPrimaria;
    private javax.swing.JRadioButton inputRdRural;
    private javax.swing.JRadioButton inputRdSecundaria;
    private javax.swing.JRadioButton inputRdUrbana;
    private javax.swing.JTextField inputTel;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDer;
    private javax.swing.JPanel jPanelDir;
    private javax.swing.JPanel jPanelEnf;
    private javax.swing.JPanel jPanelInfoPer;
    private javax.swing.JPanel jPanelInfoPer2;
    private javax.swing.JPanel jPanelInfoPer3;
    private javax.swing.JPanel jPanelIzq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelDir;
    private javax.swing.JLabel labelInfoPersonal1;
    private javax.swing.JLabel labelInfoPersonal4;
    private javax.swing.JLabel labelTipoPersona;
    private javax.swing.JLabel labelTipoPersona1;
    private javax.swing.JLabel labelZona;
    private javax.swing.JLabel msjIndicacion;
    // End of variables declaration//GEN-END:variables
}
