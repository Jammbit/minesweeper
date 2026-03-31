import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Squares extends JPanel{

    private JPanel panel;
    private game game = null;


    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponents(g);
        
        Graphics2D g2d = (Graphics2D) g;
         
        for (int x = 0; x < 9; x++){

            for (int y = 0; y < 9; y++){
                g.setColor(Color.GREEN);
                if(game != null){
                    if(game.getTile(x,y) != '?'){
                        g.setColor(Color.RED);
                    }
                }
                g2d.fillRect(x * 100, y * 100, 99, 99);

            }

        }

    }

    public Squares() {
        
        panel = new JPanel();

    }

}


public class App extends JFrame implements MouseListener{
    
    Squares panel = new Squares();
    game = new game();

    public App() {

        setTitle("Mine Sweeper");
        //size of window
        setSize(917, 930);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //center the window
        setLocationRelativeTo(null);
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
            game.flag((x / 100),(y / 100));
        }else{
            game.dig((x / 100),(y / 100));
        }
        game.printGameView();
        repaint();
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