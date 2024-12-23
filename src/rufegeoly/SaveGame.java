package rufegeoly;
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException;  
import java.util.ArrayList;

public class SaveGame {
    public SaveGame(int players_count, ArrayList<Refugee> players, Receiver_Entity Mafia_Bank, Giver_Entity NGO_Bank, int p) {
    try {
      File file = new File("Rufegeoly.txt");
      FileWriter Ovewrite = new FileWriter(file);
      
      Ovewrite.write("Players_count: " + players_count + "\n");
      for(Refugee refugee: players){
        Ovewrite.write(refugee.toString() + "\n");
      }  
      Ovewrite.write(Mafia_Bank.toString() + "\n");
      Ovewrite.write(NGO_Bank.toString() + "\n");
      Ovewrite.write("Player: " + (p+1) + " turn\n");
      Ovewrite.close();
      System.out.println("Successfully wrote to the file."); 
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
    }
}
