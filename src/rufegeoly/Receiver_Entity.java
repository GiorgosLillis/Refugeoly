package rufegeoly;

public class Receiver_Entity implements MoneyReceiver{
    private String name;
    private int money = 0;
    
    public Receiver_Entity(String name){
       this.name = name;
    }
    
    public Receiver_Entity(String name, int money){
        this.name = name;
        this.money = money;
    }
    
    public void setMoney(int money){
        this.money = money;
    }
     
    public int getMoney(){
        return money;
    }
     
    @Override  
    public void receiveMoney(int money){
        this.money += money;
    }
    
    @Override
    public String toString(){
        return "Name: " + name + " Money: " + money; 
    }
    
    
}
