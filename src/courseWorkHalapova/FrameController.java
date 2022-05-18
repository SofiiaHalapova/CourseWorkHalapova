package courseWorkHalapova;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class FrameController extends JFrame {
    private TextPanel textPanel;
    private FormPanel formPanel;

    FrameController() {
        super("Geometric progression. By Sofiia Halapova SHID-11");

        initialize();

        formPanel.setComputeListener(model -> {
            try {
                int firstNum = parseInt(model.getFirstNum());
                int comRat = parseInt(model.getComRat());
                int numTerms = parseInt(model.getNumTerms());

                if (firstNum <= 0 || comRat <= 0 || numTerms <= 0) {
                    throw new NumberFormatException();
                }
                textPanel.appendText("n" + "\t" + "x" + "\n");
                textPanel.appendText("______________" + "\n");
                for (Map.Entry entry : model.getDegrees(firstNum, comRat, numTerms).entrySet()) {
                    textPanel.appendText(entry.getKey() + "\t" + entry.getValue() + "\n");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Please ensure compliance! You must input positive whole numbers into a field",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        formPanel.setEraseListener(() -> textPanel.eraseTextArea());

        formPanel.setExitListener(() -> System.exit(0));
    }

    private void initialize() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);
    }
}




