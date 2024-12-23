package rufegeoly;

public class GetMoneyAction implements Action{
    private int money;
    
    public GetMoneyAction(){
     
    }
    
    public void setReceivemnt(int money){
        this.money = money;
    }
    
    @Override
    public void act(Refugee refugee) {
       refugee.receiveMoney(money);
    }
}
