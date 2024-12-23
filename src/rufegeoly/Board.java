
package rufegeoly;

import java.util.ArrayList;

public class Board {
    
    private final ArrayList<Squares> board;

    public Board() {
        this.board = new ArrayList<Squares>();
    }
    
    public void addSquare(int num, String text){
        Squares square = new Squares(num, text);
        board.add(square);
    }
    
    public Squares getSquare(int num){
        return board.get(num);
    }
}
