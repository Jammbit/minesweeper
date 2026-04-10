public class game {
    
    private final char flag = 'F';
    private final char bomb = 'L';
    private final char tile = '?';
    
    private final int mineFieldSize = 9;
    
    grid mineGrid;
    private char[][] gameView = new char[mineFieldSize][mineFieldSize];
    public boolean lose = false;
    
    public game(){
        
        mineGrid = new grid();
        for (int i = 0; i < mineFieldSize; i++){
            for (int b = 0; b < mineFieldSize; b++){
                gameView[i][b] = tile;
            }
        }
        
    }

    public char getTile(int x, int y){

        return gameView[x][y];

    }

    public void dig(int x, int y){
        if(gameView[y][x] == tile){
            if (mineGrid.check(y,x)){
                gameView[y][x] = bomb;
                lose = true;
            }else{
                zero(y,x);
            }
            
            
        }else if (gameView[y][x] != tile){
            System.out.println("Can't dig in an already dug square!");
        }
        
    }
    
    public void flag(int x, int y){
        
        if (gameView[y][x] == flag){
            gameView[y][x] = tile;
        }else if (gameView[y][x] == tile){
            gameView[y][x] = flag;
        }else{
            System.out.println("Cannot flag an already dug square!");
        }
        
    }

    public boolean checkWin(){
        int flags = 0;

        for (int y = 0; y < gameView.length; y++){
            for (int x = 0; x < gameView.length; x++){
                if (gameView[y][x] == flag){
                    flags++;
                }
                if (gameView[y][x] == tile){
                    return false;
                }
            }
        }
        if (flags == 10)
            return true;

        return false;
    }
    
    public boolean checkLose(){

        for (int y = 0; y < gameView.length; y++){
            for (int x = 0; x < gameView.length; x++){
                if (gameView[y][x] == 'L'){
                    return true;
                }
            }
        }

        return false;
    }

    private void zero(int x,int y){
        char bombNum;
        int x2;
        int y2;
        
        if (outOfBounds(x,y) || (gameView[x][y] != tile))
            return;
        
        bombNum = bombCheck(x,y);
        gameView[x][y] = bombNum;
        
        if (bombNum == '0'){
            for (int i = -1; i <= 1; i++) {
                for (int h = -1; h <= 1; h++) {
                    if (i == 0 && h == 0) 
                        continue;
    
                    x2 = x + i;
                    y2 = y + h;
                    
                    zero(x2, y2); 
                }
            }
        }
    }
    
    private char bombCheck(int x, int y){
        int temp = 0;
        char temp2;
        
        for (int i = -1; i < 2; i++){
                
            for (int h = -1; h < 2; h++)
            {
                
                if (outOfBounds(x + i, y + h))
                    continue;
                
                if (((y + h) == y) && ((x + i) == x)){
                    continue;
                }
                
                if (mineGrid.check(x + i, y + h)){
                    temp++;
                }
                
            }
                
        }
        
        temp2 = (char)(temp + '0');
            
        return temp2;
        
    }


    private boolean outOfBounds(int x, int y){
        
        if ((x < 0) || (x > mineFieldSize - 1))
            return true;
        
        if ((y < 0) || (y > mineFieldSize - 1))
            return true;
        
        return false;
        
    }

    public void printGameView(){
        for (int i = 0; i < mineFieldSize; i++){
            
            for (int b = 0; b < mineFieldSize; b++){
                
                System.out.print(gameView[i][b] + " ");
            }
            
            System.out.println("");
            
        }
        
    }
}