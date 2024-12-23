package rufegeoly;

public class Refugee implements MoneyGiver, MoneyReceiver{
    Board board = new Board();
    private final String name;
    private int money, stay = 0;
    private boolean alive = true;
    private boolean jacket = false;
    private boolean win = false;
    private int squares = 0;
    private Receiver_Entity expenses = new Receiver_Entity("Expenses");
    private GoToAction go;
    private Receiver_Entity Mafia_Bank;
    private Giver_Entity NGO_Bank;
    
    public Refugee(String name, int money, Board board, Receiver_Entity Mafia_Bank, Giver_Entity NGO_Bank){
        this.name = name;
        this.money = money;
        this.board = board;
        this.Mafia_Bank = Mafia_Bank;
        this.NGO_Bank = NGO_Bank;
    }
    
    public Refugee(String name, int money, int expenses, boolean alive, int square, boolean jacket,int stay, Board board, Receiver_Entity Mafia_Bank, Giver_Entity NGO_Bank){
        this.name = name;
        this.money = money;
        this.expenses.setMoney(expenses);
        this.alive = alive;
        this.squares = square;
        this.jacket = jacket;
        this.stay = stay;
        this.board = board;
        this.Mafia_Bank = Mafia_Bank;
        this.NGO_Bank = NGO_Bank;
    }
   
    public void setMoney(int money){
        this.money = money;
    }
    
    public void setStatus(boolean status){
        this.alive = status;
    }
    
    public void getJacket(boolean jacket){
        this.jacket = jacket;
    }
    
    public void setStay(int stay){
        this.stay = stay;
    }
    public void setPos(int pos){
        squares = pos;
    }
    
    public void Stay(){
        stay -= 1;
    }
    
    public void Won(){
        this.win = true;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMoney(){
        return money;
    }
    
    public double getExpenses(){
        return expenses.getMoney();
    }
    
    public boolean getStatus(){
        return alive;
    }
    
    public boolean getJacket(){
        return jacket;
    }
    
    public int getPos(){
        return squares;
    }
    
    public int CheckStay(){
        return stay;
    }
    
    public boolean showWin(){
        return win;
    }
    
    @Override
    public void giveMoney(int money){
        try{
            this.money -= money;
            expenses.receiveMoney(money);
            Mafia_Bank.receiveMoney(money);
            CheckBalance(this.money);
        }
        catch(NoMoneyException e){
            System.out.println("Player " + getName() + " got bankrupt!");
            setStatus(false);
        }
   }
    
   @Override
   public void receiveMoney(int money){
       this.money += money;
       NGO_Bank.giveMoney(money);
   }
   
    @Override
    public String toString(){
        return "Name: " + name + " Money: " + money + " Expenses: " + expenses.getMoney() + " Alive: " + alive + " Square: " + squares + " LifeVest: " + jacket + " Stay: " + stay; 
    }
    
    @Override
    public void CheckBalance(int money) throws NoMoneyException {
        if(this.money < 0){
            throw new NoMoneyException("Not enough money to pay!");
        }
    }   
    
    public void move(int dice){
        squares += dice;
        if(this.squares > 39){
        squares = squares - 39;
        squares = 39 - squares;
        }
        else if(squares == 39){
        System.out.println("Player " + name + "won!!");
        }
        System.out.println("Player move to square: " + squares);
        go = new GoToAction(squares);
        go.act(this);
        this.board.getSquare(squares).executeActions(this);
    }
    
}
