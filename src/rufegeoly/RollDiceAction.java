package rufegeoly;
import java.util.Random;

public class RollDiceAction implements Action{
    Random dice = new Random();
    private int Dice;
    
    public RollDiceAction(){
       
    }
    
    public void Roll(){
        this.Dice = this.dice.nextInt(5)+1;
        System.out.println("Dice: " + this.Dice);
    }
    
    @Override
    public void act(Refugee refugee){
        Roll();
        refugee.move(this.Dice);
    }
    
    public int getDice(){
        return Dice;
    }
}
