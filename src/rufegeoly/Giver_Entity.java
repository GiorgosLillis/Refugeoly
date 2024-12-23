package rufegeoly;

public class Giver_Entity implements MoneyGiver{
    private final String name = "NGO_Bank";
    private int money = 10000;
    
    public Giver_Entity(){
       
    }
    
    public Giver_Entity(int money){
        this.money = money;
    }
     
    public String getName(){
        return name;
    }
     
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int money){
        this.money = money;
    }
    
    @Override
    public void giveMoney(int money){
        try{
            CheckBalance(this.money - money);
            this.money -= money;
        }
        catch(NoMoneyException e){
            System.out.println(e.getMessage());
        }
    }
   
    @Override
    public String toString(){
        return "Name: " + getName() + " Money: " + getMoney(); 
    }
    
    @Override
    public void CheckBalance(int money) throws NoMoneyException {
        if(this.money < 0){
        throw new NoMoneyException("Not enough money to pay!");
        }
    }
}
