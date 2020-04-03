import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
    protected MainFrame frame;
    protected int width = 800, height = 600;
    protected BufferedImage image;
    protected Graphics2D graphics;
    protected File path = new File("");

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.setBorder(BorderFactory.createTitledBorder("Drawing panel:"));
        createOffscreenImage();
        init();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public void resetFrame() {
        frame.dispose();
        frame = new MainFrame();
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    private void createOffscreenImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    private void init() {
        setPreferredSize(new Dimension(width, height));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int sides = (int) frame.configPanel.sidesField.getValue();
                drawShape(e.getX(), e.getY(),sides);
                repaint();
            }
        });
    }
    private void drawShape(int x, int y, int sides) {
        int radius = 30;
        Random random = new Random();
        graphics.setColor(new Color(random.nextInt(0xFFFFFF)));
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}