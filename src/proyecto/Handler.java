/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Handler {
    public static final int ERROR = JOptionPane.ERROR_MESSAGE; 
    public static final int QUESTION = JOptionPane.QUESTION_MESSAGE; 
    public static final int PLAIN = JOptionPane.PLAIN_MESSAGE; 
    public static final int INFORMATION = JOptionPane.INFORMATION_MESSAGE; 
    
    public static void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
            
    public static int inputInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, message));
    }
    
    public static float inputFloat(String message) {
        return Float.parseFloat(JOptionPane.showInputDialog(null, message));
    }
    
    public static String inputString(String message) {
        return JOptionPane.showInputDialog(null, message);
    }
    
    public static byte inputByte(String message) {
        return Byte.parseByte(JOptionPane.showInputDialog(null, message));
    }
    
    public static long inputLong(String message) {
        return Long.parseLong(JOptionPane.showInputDialog(null, message));
    }
    
    public static char inputChar(String message) {
        return JOptionPane.showInputDialog(null, message).toLowerCase().charAt(0);
    }
    
    public static String capitalize(String text) {
        return (text.substring(0,1).toUpperCase() + text.substring(1, text.length())).strip();
    }
    
    
    public static int options(String message, String title) {
        Object[] options = {"Efectuar pago", "Cerrar"};  
        return JOptionPane.showOptionDialog(null, message, title, 1, INFORMATION, null, options, options[1]);
    }
}
