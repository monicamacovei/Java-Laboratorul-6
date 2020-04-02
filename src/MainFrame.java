import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    static ConfigPanel configPanel;
    ControlPanel controlPanel;
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
        canvas = new DrawingPanel(this);
        canvas.setPreferredSize(new Dimension(800,600));
        controlPanel = new ControlPanel(this);

        configPanel.submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int sides = (int) configPanel.sidesField.getValue();
                repaint();
            }
        });

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
        this.setVisible(true);
    }
}