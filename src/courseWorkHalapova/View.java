package courseWorkHalapova;

import javax.swing.*;

/* Author: Halapova Sofiia SHID-11
 *  State University of Telecommunications */

public class View {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception e) {
                    System.out.println("Unsuccessful change of the theme");
                }
                new FrameController();
            }
        });
    }
}

