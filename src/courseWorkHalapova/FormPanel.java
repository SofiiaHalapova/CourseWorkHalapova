package courseWorkHalapova;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {
    private JLabel firstNumLabel;
    private JLabel comRatLabel;
    private JLabel numTermsLabel;
    private JTextField firstNumField;
    private JTextField comRatField;
    private JTextField numTermsField;
    private JButton btnCompute;
    private JButton btnErase;
    private JButton btnExit;
    private ComputeListener computeListener;
    private EraseListener eraseListener;
    private ExitListener exitListener;

    public void setComputeListener(ComputeListener listener) {
        this.computeListener = listener;
    }

    public void setEraseListener(EraseListener listener) {
        this.eraseListener = listener;
    }

    public void setExitListener(ExitListener listener) {
        this.exitListener = listener;
    }

    public FormPanel() {

        initialize();

        btnCompute.addActionListener((e) -> {
            Model model = new Model(firstNumField.getText(), comRatField.getText(), numTermsField.getText());

            if (computeListener != null) {
                computeListener.computeEventOccurred(model);
            }

            firstNumField.setEditable(false);
            comRatField.setEditable(false);
            numTermsField.setEditable(false);

            btnCompute.setEnabled(false);
        });

        btnErase.addActionListener((e) -> {
            firstNumField.setText("");
            comRatField.setText("");
            numTermsField.setText("");

            if (eraseListener != null) {
                eraseListener.eraseEventOccurred();
            }

            firstNumField.setEditable(true);
            comRatField.setEditable(true);
            numTermsField.setEditable(true);

            btnCompute.setEnabled(true);
        });

        btnExit.addActionListener(e -> {
            if (exitListener != null) {
                exitListener.exitEventOccurred();
            }
        });
    }

    private void initialize() {
        Dimension dim = this.getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border border = BorderFactory.createTitledBorder("Enter your numbers");
        setBorder(border);

        firstNumLabel = new JLabel("First number");
        comRatLabel = new JLabel("Common Ratio");
        numTermsLabel = new JLabel("Number of terms");
        firstNumField = new JTextField(10);
        comRatField = new JTextField(10);
        numTermsField = new JTextField(10);
        btnCompute = new JButton("Compute");
        btnErase = new JButton("Erase");
        btnExit = new JButton("Exit");

        GridBagLayout layoutForInputs = new GridBagLayout();
        setLayout(layoutForInputs);

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        add(firstNumLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(firstNumField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(comRatLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(comRatField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(numTermsLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(numTermsField, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(btnCompute, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(btnErase, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(btnExit, gc);
    }
}

