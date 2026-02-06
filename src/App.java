import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Squares extends JPanel {

    // @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponents(g);
        
        Graphics2D g2d = (Graphics2D) g;

        for (int x = 0; x < 9; x++){

            for (int y = 0; y < 9; y++){
                g.setColor(Color.GREEN);
                g2d.fillRect(x * 100, y * 100, 99, 99);

            }

        }
        
    }
}


public class App extends JFrame implements MouseListener {
    
    private JPanel panel;
    private game g = new game();

    public App() {
        setTitle("Mine Sweeper");
        //size of window
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //center the window
        setLocationRelativeTo(null);
        
        panel = new JPanel();
        //add the MouseListener to the panel
        panel.addMouseListener(this); 
        
        add(panel);

    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        System.out.println("Click at X: " + x + ", Y: " + y);
        System.out.println("Board Click at X:" + (x / 50) + ", Y: " + (y / 50));
        
        if(SwingUtilities.isRightMouseButton(e)){
            g.flag((x / 100),(y / 100));
        }else{
            g.dig((x / 100),(y / 100));
        }
        g.printGameView();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}