package rufegeoly;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Squares extends Board{
    private final int num;
    private final String text;
    
    ArrayList<Action> actions;
    
    public Squares(int num, String text){
        this.actions = new ArrayList<Action>();
        this.num = num;
        this.text = text;
        setActions();
    }
    
    public void setActions(){
        if(text.contains("Pay") || text.contains("pay")){
            PayMoneyAction pay = new PayMoneyAction();
            switch(num){
                case 1:
                    pay.setPayment(100);
                    break;
                case 3:
                    pay.setPayment(300);
                    break;
                case 6:
                    pay.setPayment(1000);
                    break;
                case 9:
                    pay.setPayment(3000);
                    break;
                case 13:
                    pay.setPayment(500);
                    break;
                case 26:
                    pay.setPayment(1000);
                    break;
                case 31:
                    pay.setPayment(800);
                    break;
                case 37:
                    pay.setPayment(1000);
                    break;
            }
            actions.add(pay);
        }
        if(text.contains("Receive") || text.contains("receive")){
            GetMoneyAction get = new GetMoneyAction();
            get.setReceivemnt(1000);
            actions.add(get);
        }
        if(text.contains("Back to") || text.contains("back to") || text.contains("Jump to") || text.contains("go backwards")){
            GoToAction go = new GoToAction(0);
            switch(num){
            case 4:
                go.GoTo(0);
                break;
            case 5:
                go.GoTo(0);
                break;
            case 15:
                go.GoTo(5);
                break;
            case 18:
                go.GoTo(22);
                break;
            case 22:
                RollDiceAction dice = new RollDiceAction();
                dice.Roll();
                go.GoTo((22-dice.getDice()));
                break;
            case 23:
                go.GoTo(29);
                break;
            case 25:
                go.GoTo(15);
                break;
            case 29:
                go.GoTo(31);
                break;
            case 30:
                go.GoTo(24);
                break;
            case 33:
                go.GoTo(17);
                break;
            case 35:
                go.GoTo(25);
                break;
            case 38:
                go.GoTo(0);
                break;    
            }    
            actions.add(go);
        }
        if(text.contains("Roll") || text.contains("roll")){
            RollDiceAction dice = new RollDiceAction();
            actions.add(dice);
        }
        if(text.contains("Stay") || text.contains("stay")){
            StayAction stay = new StayAction(1);
            actions.add(stay);
        }
        if(text.contains("Live Vest")){
            GetVest vest = new GetVest();
            actions.add(vest);
        }
        if(text.contains("Dead")){
            DieAction dead = new DieAction();
            actions.add(dead);
        }
        if(text.contains("win")){
            WinAction win = new WinAction();
            actions.add(win);
        }
    }
    
    public void executeActions(Refugee refugee){
        System.out.println(toString() + "\n");
        for(Action element: actions){
            element.act(refugee);
        }
    }
    
    @Override
    public String toString(){
        return "\nNumber: " + this.num + "\nText: " + this.text; 
    }
}
