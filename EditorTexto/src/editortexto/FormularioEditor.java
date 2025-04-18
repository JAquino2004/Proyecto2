/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Joshua
 */
public class FormularioEditor extends javax.swing.JFrame {

    String ruta = "";
   
    int contador=0;
    int contador2=0;
    Stack<String> undo=new Stack<String>();
    Stack<String> redo=new Stack<String>();
    Stack<String> tiempo=new Stack<String>();
    Timer timer = new Timer();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if(!tiempo.empty())tiempo.clear();
               tiempo.push(jTextArea1.getText());
            }
        };
        
      
        

    /**
     * Creates new form NewJFrame
     */
    public FormularioEditor() {
        initComponents();
        setLocationRelativeTo(null);
        if (this.ruta != "") {
            setTitle(this.ruta);
        } else {
            setTitle("untitled");
        }
        this.undo.push("");
        iniciarTarea();

    }
    private void iniciarTarea() {
        tarea = new TimerTask() {
            @Override
            public void run() {
                 if(!tiempo.empty())tiempo.clear();
                
                 tiempo.push(jTextArea1.getText());
            }
        };

        timer.scheduleAtFixedRate(tarea, 5000, 5000); 
    }
    private void guardarTexto() {
                String actual = jTextArea1.getText();
                if (!actual.equals(this.undo.peek())&& this.contador==0) {
                    undo.push(actual);
                    
                }
            }
    
    private void guardarTexto2() {
                String actual = jTextArea1.getText();
                if (!actual.equals(this.undo.peek())&& this.contador==0 && this.contador2==0) {
                    undo.push(actual);
                   
                }
            }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea1CaretUpdate(evt);
            }
        });
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jTextArea1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextArea1InputMethodTextChanged(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Open");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Save");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Save as");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Undo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Redo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setText("Encontrar palabra");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Encontrar frase");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int salida = JOptionPane.showConfirmDialog(null, "¿Quieres crear uno nuevo?", "New", JOptionPane.YES_NO_CANCEL_OPTION);
        if (salida == JOptionPane.YES_OPTION) {
            jTextArea1.setText("");
            this.ruta = "";
            setTitle("untitled");
            this.undo.clear();
            this.undo.push("");
            this.redo.clear();
            this.tiempo.clear();
            
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser fc = new JFileChooser();

        int resultado = fc.showOpenDialog(null);
        File directorioSeleccionado = fc.getSelectedFile();
        this.ruta = directorioSeleccionado.getAbsolutePath();
        setTitle(this.ruta);
        if (this.ruta.contains(".txt")) {
            StringBuilder contenido = new StringBuilder();
            try ( BufferedReader lecturaArchivo = new BufferedReader(new FileReader(this.ruta))) {

                String lectura;
                while ((lectura = lecturaArchivo.readLine()) != null) {
                    contenido.append(lectura).append("\n");

                }
                 this.undo.clear();
            this.undo.push("");
            this.redo.clear();
            this.tiempo.clear();
                jTextArea1.setText(contenido.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "NO SE HA PODIDO LEER EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sólo se aceptan archivos txt", "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed
 
 
 
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (!this.ruta.equals("")) {
            File archivo = new File(this.ruta);
            try {
                FileWriter lector = new FileWriter(archivo);
                BufferedWriter b = new BufferedWriter(lector);

                b.write(jTextArea1.getText());
                b.close();
            } catch (Exception e) {

            }
        } else {
  JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo de texto");

       
        int seleccion = fileChooser.showSaveDialog(null);

       
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            this.ruta=archivoSeleccionado.getAbsolutePath();
            setTitle(this.ruta);

           
            if (!archivoSeleccionado.getName().toLowerCase().endsWith(".txt")) {
                archivoSeleccionado = new File(archivoSeleccionado.getAbsolutePath() + ".txt");
                this.ruta=archivoSeleccionado.getAbsolutePath()+".txt";
            setTitle(this.ruta);
            }

            try (FileWriter writer = new FileWriter(archivoSeleccionado)) {
               
                String contenido = jTextArea1.getText();

              
                writer.write(contenido);

                JOptionPane.showMessageDialog(null, "Archivo guardado en:\n" + archivoSeleccionado.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo:\n" + e.getMessage());
            }
        } else {
            System.out.println("El usuario canceló la operación.");
        }
         
         
        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo de texto");

       
        int seleccion = fileChooser.showSaveDialog(null);

        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
           
            this.ruta=archivoSeleccionado.getAbsolutePath();
            setTitle(this.ruta);
           
            if (!archivoSeleccionado.getName().toLowerCase().endsWith(".txt")) {
                archivoSeleccionado = new File(archivoSeleccionado.getAbsolutePath() + ".txt");
                this.ruta=archivoSeleccionado.getAbsolutePath()+".txt";
            setTitle(this.ruta);
            }

            try (FileWriter writer = new FileWriter(archivoSeleccionado)) {
                
                String contenido = jTextArea1.getText();

                
                writer.write(contenido);

                JOptionPane.showMessageDialog(null, "Archivo guardado en:\n" + archivoSeleccionado.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo:\n" + e.getMessage());
            }
        } else {
            System.out.println("El usuario canceló la operación.");
        }
         
         
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
String ahora=jTextArea1.getText();
        if (!undo.isEmpty()) {
   
               
                jTextArea1.setText(undo.pop());
                this.contador=0;
                this.contador2=0;
            }   
        this.undo.push(ahora);
        this.redo.push(ahora);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea1CaretUpdate
      

    }//GEN-LAST:event_jTextArea1CaretUpdate

    private void jTextArea1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextArea1InputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextArea1InputMethodTextChanged

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
if(!Character.isISOControl(evt.getKeyChar()) && contador==1){
             contador=0;
             
         }        
        tarea.cancel();
        
         iniciarTarea();
         
         if (evt.getKeyChar()=='\b'){
             if(!tiempo.isEmpty()) undo.push(tiempo.pop());
         }
           if(!Character.isISOControl(evt.getKeyChar())&& !tiempo.isEmpty() )undo.push(tiempo.pop());
        
        
         
      
    
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
         if (evt.getKeyChar()=='\b'){
         //if(!tiempo.isEmpty()) undo.push(tiempo.pop());
        guardarTexto();
        this.contador=1;
        
         }
         
        // if(!Character.isISOControl(evt.getKeyChar())&& !tiempo.isEmpty() )undo.push(tiempo.pop());
         
         if(!Character.isISOControl(evt.getKeyChar()) && jTextArea1.getSelectedText()!=null) this.undo.push(jTextArea1.getText());
         
         if (!Character.isISOControl(evt.getKeyChar()) && jTextArea1.getCaretPosition()!=jTextArea1.getText().length()){
        guardarTexto2();
        this.contador2=1;
         }
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        
        String ahora=jTextArea1.getText();
        if(!this.redo.isEmpty()){
            jTextArea1.setText(this.redo.pop());
        }
        this.redo.push(ahora);
        this.undo.push(ahora);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      EditorTexto a=new EditorTexto();
       String palabra = showInputDialog("Ingresa la frase que quieres encontrar");
        List<Texto> b=a.encontrarPalabras(jTextArea1.getText());
        Arbol arbol=new Arbol();
        Highlighter resaltador = jTextArea1.getHighlighter();
        Highlighter.HighlightPainter painter =  new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        resaltador.removeAllHighlights();
        if(b.isEmpty()){
          JOptionPane.showMessageDialog(null, "la frase no existe", "error", JOptionPane.ERROR_MESSAGE);
       }else{
            for (Texto texto : b){
                arbol.insertar(new Nodo(texto));
                
            }
            List<Texto> c=arbol.buscar(palabra);
           try{
            for (Texto texto : c){
                resaltador.addHighlight(texto.inicio, texto.fin, painter);
                
            }
        }catch (Exception j){
            
        }
       }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       
        EditorTexto a=new EditorTexto();
       String frase = showInputDialog("Ingresa la frase que quieres encontrar");
       List<Texto> b=a.encontrarFrases(frase, jTextArea1.getText());
       Highlighter resaltador = jTextArea1.getHighlighter();
        Highlighter.HighlightPainter painter =  new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        resaltador.removeAllHighlights();
       if(b.isEmpty()){
          JOptionPane.showMessageDialog(null, "la frase no existe", "error", JOptionPane.ERROR_MESSAGE);
       }else{
           try{
            for (Texto texto : b){
                resaltador.addHighlight(texto.inicio, texto.fin, painter);
                
            }
        }catch (Exception j){
            
        }
       }
       
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
