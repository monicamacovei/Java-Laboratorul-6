import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
    protected MainFrame frame;
    protected int W = 800, H = 600;
    protected BufferedImage image;
    protected Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.setBorder(BorderFactory.createTitledBorder("Drawing panel:"));
        createOffscreenImage();
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.RED); //fill the image with white
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawImage(image, 0, 0, null);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
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