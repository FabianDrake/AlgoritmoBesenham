import java.awt.*;
import javax.swing.*;

public class BresenhamLine extends JPanel {
    private int x1, y1, x2, y2;

    public BresenhamLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLineBresenham(g, x1, y1, x2, y2);
    }

    public void drawLineBresenham(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawRect(x1, y1, 1, 1); // Dibuja un pixel

            if (x1 == x2 && y1 == y2) break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bresenham Line Drawing");
        BresenhamLine panel = new BresenhamLine(50, 50, 200, 150);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
