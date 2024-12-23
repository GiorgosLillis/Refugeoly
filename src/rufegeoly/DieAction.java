
package rufegeoly;

public class DieAction implements Action{
    public DieAction(){
        
    }
    @Override
    public void act(Refugee refugee) {
       if(refugee.getJacket() == true){
           System.out.println("Player " + refugee.getName() + " got saved by the jacket!");
           refugee.getJacket(false);
       }
       else{
           refugee.setStatus(false);
       }
    }
    
}
