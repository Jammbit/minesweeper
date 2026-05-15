public class game {
    
    private final char FLAG = 'F';
    private final char BOMB = 'L';
    private final char TILE = '?';
    
    private final int mineFieldSize = 9;
    
    grid mineGrid;
    private char[][] gameView = new char[mineFieldSize][mineFieldSize];
    public boolean lose = false;
    
    public game(){
        
        mineGrid = new grid();
        for (int i = 0; i < mineFieldSize; i++){
            for (int b = 0; b < mineFieldSize; b++){
                gameView[i][b] = TILE;
            }
        }
        
    }

    public char getTile(int x, int y){

        return gameView[x][y];

    }

    public void dig(int x, int y){
        if(gameView[y][x] == TILE){
            if (mineGrid.check(y,x)){
                gameView[y][x] = BOMB;
                lose = true;
            }else{
                zero(y,x);
            }
            
        }else if (gameView[y][x] != TILE){
            System.out.println("Can't dig in an already dug square!");
        }
        
    }
    
    public void flag(int x, int y){
        
        if (gameView[y][x] == FLAG){
            gameView[y][x] = TILE;
        }else if (gameView[y][x] == TILE){
            gameView[y][x] = FLAG;
        }else{
            System.out.println("Cannot flag an already dug square!");
        }
        
    }

    public boolean checkWin(){
        int flags = 0;

        for (int y = 0; y < gameView.length; y++){
            for (int x = 0; x < gameView.length; x++){
                if (gameView[y][x] == FLAG){
                    flags++;
                }
                if (gameView[y][x] == TILE){
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

    // public void clearSurrounding(int x, int y){
    //     int flags = 0;
    //     for(int i = -1; i <= 1; i++){
    //         for (int h = -1; h <= 1; h++){
    //             if (i == 0 && h == 0)
    //                 continue;
    //             if(outOfBounds(x + i, y + h))
    //                 continue;
    //             if (gameView[x + i][y + h] == FLAG)
    //                 flags++;
    //         }
    //     }
    //     if (gameView[x][y] == (char)(flags + '0')){
    //         for(int i = -1; i <= 1; i++){
    //             for (int h = -1; h <= 1; h++){
    //                 if (i == 0 && h == 0)
    //                     continue;
    //                 if(outOfBounds(x + i, y + h))
    //                     continue;
    //                 if (gameView[x + i][y + h] == FLAG)
    //                     continue;
    //                 dig(y + i,x + h);
    //             }
    //         }
    //     }
    // }

    private void zero(int x,int y){
        char bombNum;
        int x2;
        int y2;
        
        if (outOfBounds(x,y) || (gameView[x][y] != TILE))
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
        int bombs = 0;
        
        for (int i = -1; i < 2; i++){
                
            for (int h = -1; h < 2; h++)
            {
                
                if (outOfBounds(x + i, y + h))
                    continue;
                
                if (((y + h) == y) && ((x + i) == x)){
                    continue;
                }
                
                if (mineGrid.check(x + i, y + h)){
                    bombs++;
                }
                
            }
                
        }
        
        
            
        return (char)(bombs + '0');
        
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