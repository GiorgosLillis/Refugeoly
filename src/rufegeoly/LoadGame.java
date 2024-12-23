package rufegeoly;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadGame{
    private int Square, stay, money, expenses, count, turn;
    private boolean alive,jacket;
    private String[] elements;
    
    public LoadGame(ArrayList<Refugee> players, Receiver_Entity Mafia_Bank, Giver_Entity NGO_Bank,Board board) {
        try {
            File file = new File("Rufegeoly.txt");
            Scanner reader = new Scanner(file);
            String input = reader.nextLine(), name;
            int i, player=0;
            
            while(reader.hasNextLine()) {
                i = 1;
                elements = input.split(" ");
                
                if(input.contains("Mafia_Bank")){
                   money = Integer.parseInt(elements[i += 2]);
                   Mafia_Bank.setMoney(money);
                }
                else if(input.contains("NGO_Bank")){
                   money = Integer.parseInt(elements[i += 2]);
                   NGO_Bank.setMoney(money);
                } 
                else if(input.contains("Players_count:")){
                   count = Integer.parseInt(elements[1]);
                }
                else if(input.contains("Player")){
                   turn = Integer.parseInt(elements[1]);
                }
                else{
                   name = elements[i]; 
                   money = Integer.parseInt(elements[i += 2]);
                   expenses = Integer.parseInt(elements[i += 2]);
                   alive = Boolean.parseBoolean(elements[i += 2]);
                   Square = Integer.parseInt(elements[i += 2]);
                   jacket = Boolean.parseBoolean(elements[i += 2]);
                   stay = Integer.parseInt(elements[i + 2]);
                   Refugee refugee = new Refugee(name, money, expenses, alive, Square, jacket, stay, board, Mafia_Bank, NGO_Bank);
                   if(player < players.size()){
                      players.set(player, refugee);
                   }
                   else{
                       players.add(refugee);
                   }
                   player += 1;
                } 
                input = reader.nextLine();
                }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
    
    public int getCount(){
        return count;
    }
    public int getPos(){
        return turn;
    }
}
