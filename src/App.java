import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class App extends JFrame implements MouseListener {
    
    private JPanel panel;
    private game g = new game();
    // @Override
    // protected void paintComponent(Graphics g){
        
    //     super.paintComponent(g);
        
        
        
    // }
    
    
    
    public App() {
        setTitle("Mouse Click Detector");
        //size of window
        setSize(450, 450);
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
            new MouseClickDetector().setVisible(true);
        });
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        System.out.println("Click at X: " + x + ", Y: " + y);
        System.out.println("Board Click at X:" + (x / 50) + ", Y: " + (y / 50));
        
        if(SwingUtilities.isRightMouseButton(e)){
            g.flag((x / 50),(y / 50));
        }else{
            g.dig((x / 50),(y / 50));
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