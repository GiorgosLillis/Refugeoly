package rufegeoly;

public class PayMoneyAction implements Action{
    private int money;
    
    public PayMoneyAction(){
       
    }
    
    public void setPayment(int money){
        this.money = money;
    } 
    
    @Override
    public void act(Refugee refugee){
        refugee.giveMoney(money);
    }
  
}
