/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 84373
 */
public class Hepler {

    private Hepler() {
    }
    
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    
    public static boolean  checkNull(JTextField tf , String mss){
        if (tf.getText().equals("")){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkNumber(JTextField tf , String mss){
        try { 
            double so = Integer.parseInt(tf.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
     public static boolean checkDate(JTextField tf , String mss){
        try {
            Date date = SIMPLE_DATE_FORMAT.parse(tf.getText());
            
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
}
