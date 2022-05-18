package courseWorkHalapova;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea;

    public TextPanel() {
        initialize();
    }

    public void eraseTextArea(){
        textArea.setText("");
    }

    public void appendText(String text) {
        textArea.append(text);
    }

    private void initialize(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());

        add(textArea, BorderLayout.CENTER);

        Border border = BorderFactory.createTitledBorder("Output:");
        setBorder(border);

        textArea.setEditable(false);
    }
}

