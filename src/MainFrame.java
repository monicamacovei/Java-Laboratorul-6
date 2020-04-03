import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    ShapeSettings shapeSettings;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rootPane.setBorder(BorderFactory.createTitledBorder("Drawing content"));
        rootPane.setPreferredSize(new Dimension(800, 600));

        configPanel = new ConfigPanel(this);
        shapeSettings = new ShapeSettings(this);
        canvas = new DrawingPanel(this);
        canvas.setPreferredSize(new Dimension(800,600));
        controlPanel = new ControlPanel(this);


        shapeSettings.submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox shapeCombo = shapeSettings.getShapeCombo();
                if(shapeCombo.getSelectedItem() == "Hexagon") {
                    configPanel.sidesField.setValue(6);
                }
                else if(shapeCombo.getSelectedItem() == "Square"){
                    configPanel.sidesField.setValue(4);
                }
                repaint();
            }
        });

        add(configPanel, BorderLayout.BEFORE_FIRST_LINE);
        add(shapeSettings, BorderLayout.LINE_START);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
        this.setVisible(true);
    }
}