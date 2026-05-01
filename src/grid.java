public class grid {
    
    
    private final int MINE_FIELD_SIZE = 9;
    private final int MINE_COUNT = 10;
    
    
    private int[][] theGrid = new int[MINE_FIELD_SIZE][MINE_FIELD_SIZE];
    private int test;
    
    public grid(){
        
        for (int i = 0; i < MINE_FIELD_SIZE; i++){
            for (int b = 0; b < MINE_FIELD_SIZE; b++){
                theGrid[i][b] = 0;
            }
        }
        
        int x;
        int y;
        
        for (int i = 0; i < MINE_COUNT; i++){
            
            x = ((int) (Math.random() * MINE_FIELD_SIZE));
            y = ((int) (Math.random() * MINE_FIELD_SIZE));
            
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
        
        for (int i = 0; i < MINE_FIELD_SIZE; i++){
            for (int b = 0; b < MINE_FIELD_SIZE; b++){
            
                System.out.print(theGrid[i][b] + " ");
                test += theGrid[i][b];
            }
            
            System.out.println("");
            
        }
        System.out.println(test);
    }
    
}