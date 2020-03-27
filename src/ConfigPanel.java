import javax.swing.*;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel sidesLabel; // text
    JSpinner sidesField; // input field
    JComboBox colorCombo; // select options

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number
        String colors[] = {"Random", "Black"};
        sidesField.setValue(colors);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}