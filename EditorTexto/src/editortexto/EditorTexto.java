/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Joshua
 */

class Texto{
    String palabra;
    int inicio;
    int fin;
    public Texto(String palabra, int inicio, int fin){
        this.palabra=palabra;
        this.inicio=inicio;
        this.fin=fin;
    }
}
public class EditorTexto {
    
    
 public static List<Texto> encontrarFrases(String frase, String textoCompleto) {
        List<Texto> coincidencias = new ArrayList<>();
        String texto = textoCompleto.toLowerCase();
        String fraseProcesada = frase.toLowerCase().trim();

        int index = 0;
        while ((index = texto.indexOf(fraseProcesada, index)) >= 0) {
            int fin = index + fraseProcesada.length();
            coincidencias.add(new Texto(fraseProcesada, index, fin));
            index = fin + 1;
        }    
    return coincidencias;
}
 
  public static List<Texto> encontrarPalabras(String texto) {
        List<Texto> coincidencias = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^\\s,\\.]+");
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            String palabra = matcher.group();
            int inicio = matcher.start();
            int fin = matcher.end(); 
             coincidencias.add(new Texto(palabra, inicio, fin));
            
        }
        return coincidencias;
    }
 
}
