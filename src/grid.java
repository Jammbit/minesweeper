public class grid {
    
    
    private final int mineFieldSize = 9;
    private final int mineCount = 10;
    
    
    private int[][] theGrid = new int[mineFieldSize][mineFieldSize];
    private int test;
    
    public grid(){
        
        for (int i = 0; i < mineFieldSize; i++){
            for (int b = 0; b < mineFieldSize; b++){
                theGrid[i][b] = 0;
            }
        }
        
        int x;
        int y;
        
        for (int i = 0; i < mineCount; i++){
            
            x = ((int) (Math.random() * mineFieldSize));
            y = ((int) (Math.random() * mineFieldSize));
            
            if (theGrid[x][y] == 0){
                theGrid[x][y] = 1;
            }else if (theGrid[x][y] == 1){
                i--;
            }
        }
        
    }
    
    public boolean check(int x, int y){
        
        if (theGrid[x][y] == 1){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    //for testing
    public void printGrid(){
        
        for (int i = 0; i < mineFieldSize; i++){
            for (int b = 0; b < mineFieldSize; b++){
            
                System.out.print(theGrid[i][b] + " ");
                test += theGrid[i][b];
            }
            
            System.out.println("");
            
        }
        System.out.println(test);
    }
    
}