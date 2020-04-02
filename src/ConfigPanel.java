import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel sidesLabel = new JLabel(); // text
    JSpinner sidesField = new JSpinner(); // input field
    JComboBox colorCombo; // select options
    JButton submitButton = new JButton("Submit");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number
        String colors[] = {"Random", "Black"};
        colorCombo = new JComboBox(colors);
        colorCombo.setEditable(true);
        colorCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String chosenName =  (String) colorCombo.getSelectedItem();
            }
        });
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
        add(submitButton);
    }
}