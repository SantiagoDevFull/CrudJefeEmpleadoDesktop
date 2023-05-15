package Util;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Mensajes {

    public static void MsgAdvertencia(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public static void MsgSatisfactorio(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Proceso exitoso", JOptionPane.DEFAULT_OPTION, (new ImageIcon(Iconos.ICONO_CHECK)));
    }

    public static void MsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void MsgInformativo(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void MsgTextArea(String msg) {
        JTextArea area = new JTextArea();
        area.setFont(new Font("monospaced", Font.PLAIN, 16));
        area.setText(msg);
        JOptionPane.showMessageDialog(null, area);
    }
    
    public static int MsgPregunta(String msg){
        int res;
        res=JOptionPane.showConfirmDialog(null, msg);
        return res;
    }

}
