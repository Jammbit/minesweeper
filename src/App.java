import java.util.Scanner;

public class App
{
    
    public static void main(String[] args)
    {
        //size of minefield (10,10)
        final int mineFieldSize = 9;
        
        int x;
        int y;
        boolean flag;
        int choice;
        Scanner input = new Scanner(System.in);
        
        game g = new game();
        
        g.printGameView();
        // while (true){1
        while (g.lose == false){


            System.out.println("1. Dig\n2. Flag\n3. Quit \n(Input 1,2, or 3)");
            choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1) {
                flag = false;
            }else if (choice == 2) {
                flag = true;
            }else if (choice == 3){
                break;
            }else{
                System.out.println("Invalid Option");
                continue;
            }
            
            
            System.out.print("X:" );
            x = input.nextInt();
            input.nextLine();
            
            System.out.print("Y:" );
            y = input.nextInt();
            input.nextLine();
            
            if (x < 0 || x > mineFieldSize - 1 || y < 0 || y > mineFieldSize - 1){
                System.out.println("Invalid Coordinates");
                continue;
            }
            
            if (flag){
                g.flag(x,y);
            } else if (!flag){
                g.dig(x,y);
            }
            
            System.out.println("---------------------");
            g.printGameView();
        }
        
    }
}