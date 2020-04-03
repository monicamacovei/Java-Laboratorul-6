import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    MainFrame frame;
    JFileChooser fileChooser = new JFileChooser();
    JButton fileBtn = new JButton("Choose file");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        fileBtn.addActionListener(this::chooseFile);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        add(fileBtn);
    }

    private void chooseFile(ActionEvent actionEvent) {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().isDirectory()) {
                frame.canvas.setPath(fileChooser.getSelectedFile());
            }
        }
    }

    private void exit(ActionEvent actionEvent) {
        frame.dispose();
    }

    private void reset(ActionEvent actionEvent) {
        frame.canvas.resetFrame();
    }

    private void load(ActionEvent actionEvent) {
        try {
            File path = frame.canvas.getPath();
            if(path.length() != 0) {
                frame.canvas.setImage(ImageIO.read(new File(path + "/draw.png")));
            } else {
                frame.canvas.setImage(ImageIO.read(new File("draw.png")));
            }
        } catch (IOException exception) { System.err.println(exception); }
        repaint();
    }

    private void save(ActionEvent e) {
        try {
            File path = frame.canvas.getPath();
            if(path.length() != 0) {
                ImageIO.write(frame.canvas.image, "PNG", new File(path + "/draw.png"));
            } else {
                ImageIO.write(frame.canvas.image, "PNG", new File( "draw.png"));
            }
        } catch (IOException exception) { System.err.println(exception); }
    }
}