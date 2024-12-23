package rufegeoly;

import java.util.Scanner;
import java.util.ArrayList; 
import java.io.File;  
import java.io.FileNotFoundException;
import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        
        Board board = new Board();
        try {
            File file = new File("refugeoly-squares-win.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
            int num = myReader.nextInt();
            myReader.nextLine();
            String text = myReader.nextLine();
            myReader.nextLine();
            board.addSquare(num, text);
        }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!");
            exit(1);
        }
        System.out.println();
    
        Scanner input = new Scanner(System.in);
        ArrayList<Refugee> players = new ArrayList<>();
        int players_count;
       
        System.out.println("WELCOME TO REFUGEOLY!");
        System.out.println("How many players?(2 to 4)");
        
        while(true){
            players_count = input.nextInt();
            if(players_count < 2 || players_count > 4){
                System.out.println("INVALID NUMBER TYPED!!");
            }
            else{
                break;
            }
        } 
        
        Receiver_Entity Mafia_Bank = new Receiver_Entity("Mafia_Bank");
        Giver_Entity NGO_Bank = new Giver_Entity(); 
        input.nextLine();
        for(int i = 0; i < players_count; i++){
            System.out.println("Player " + (i+1) +" name: ");
            String name = input.nextLine();
            Refugee player = new Refugee(name, 10000, board, Mafia_Bank, NGO_Bank);
            players.add(player);
            System.out.println(players.get(i).toString());
        }
      
    String turn;
    int p = 0, i=0;  
    Refugee player;
    RollDiceAction dice = new RollDiceAction();
    
    while(true){
            i += 1;
            System.out.println("ROUND " + i);
            player = players.get(p);
            
            for(Refugee pl: players){
                if(players_count == 1){
                    pl.Won();
                }
                if(pl.showWin() == true){
                    System.out.println("PLAYER " + pl.getName() + " WON!!!");
                    return;
                }
                else if(pl.getStatus() == false){
                    players.remove(pl);
                    players_count -= 1;
                }
            }
            System.out.println(player.toString());
            System.out.println(Mafia_Bank.toString());
            System.out.println(NGO_Bank.toString());    
            System.out.println("Press any key to throw dice. Type 'save' to save game");
            System.out.print(player.getName() + " turn: ");
            turn = input.nextLine();
              switch (turn) {
                case "save" -> {
                    System.out.println("Saving game");
                    SaveGame save = new SaveGame(players_count ,players, Mafia_Bank, NGO_Bank, p);
                    break;
                }
                case "load" -> {
                    System.out.println("Close game?");
                    String answer = input.nextLine();
                    switch (answer){
                        case "yes" ->{
                            System.out.println("Loading game");
                            LoadGame load = new LoadGame(players, Mafia_Bank, NGO_Bank, board);
                            players_count = load.getCount();
                            p = load.getPos();
                        }
                        default ->{
                            System.out.println("Game continues");
                            break;
                        }
                    }
                    break;
                }
                case "exit" -> {
                    return;
                }
                default ->{
                      if(player.CheckStay() > 0){
                          System.out.println("Player " + player.getName() + " stays for this round!\n");
                          player.Stay();
                      }  
                      else{
                        dice.act(player);
                      }
                    p += 1;
                    if(p >= players_count){
                        p = 0;
                    }
                    break;
                }
                }
      }
        
    }
}
