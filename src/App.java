import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Squares extends JPanel{

    private JPanel panel;
    private game theGame;
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponents(g);
        
        Graphics2D g2d = (Graphics2D) g;
         
        for (int x = 0; x < 9; x++){

            for (int y = 0; y < 9; y++){
                g.setColor(Color.GREEN);
                if(theGame.getTile(y,x) != '?' && theGame.getTile(y,x) != 'L'){
                    g.setColor(Color.LIGHT_GRAY);
                }else if (theGame.getTile(y,x) == 'L'){
                    g.setColor(Color.RED);
                }
                g2d.fillRect(x * 100, y * 100, 99, 99);

                g.setColor(Color.BLUE);
                g.setFont(new Font("Serif", Font.BOLD, 50));
                if(theGame.getTile(y,x) != '?'){

                    g.drawString(Character.toString(theGame.getTile(y,x)), (x * 100) + 35, (y * 100) + 65);

                }

            }

        }

    }

    public Squares(game g) {
        
        panel = new JPanel();
        theGame = g;

    }

}


public class App extends JFrame implements MouseListener{
    
    game theGame = new game();
    Squares panel = new Squares(theGame);

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
            theGame.flag((x / 100),(y / 100));
        }else{
            theGame.dig((x / 100),(y / 100));
        }
        theGame.printGameView();
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