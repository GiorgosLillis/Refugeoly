package rufegeoly;

public interface MoneyGiver {
    
    public abstract void giveMoney(int money);
    public abstract void CheckBalance(int money) throws NoMoneyException;
}
