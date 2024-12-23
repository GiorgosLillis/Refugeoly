
package rufegeoly;

public class WinAction implements Action{
    
    public WinAction(){
        
    }
    
    @Override
    public void act(Refugee refugee) {
       refugee.Won();
    }
}
