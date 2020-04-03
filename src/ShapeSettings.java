import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeSettings extends JPanel {
    MainFrame frame;
    JLabel shapesLabel = new JLabel();
    JComboBox shapeCombo;
    JButton submitButton = new JButton("Submit shape");

    public ShapeSettings(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JComboBox getShapeCombo() {
        return shapeCombo;
    }

    private void init() {
        shapesLabel = new JLabel("Number of sides:");
        String shapes[] = {"Custom","Hexagon", "Square"};
        shapeCombo = new JComboBox(shapes);
        shapeCombo.setEditable(true);
        shapeCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String chosenName =  (String) shapeCombo.getSelectedItem();
            }
        });
        add(shapesLabel);
        add(shapeCombo);
        add(submitButton);
    }
}