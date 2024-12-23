package rufegeoly;

public class GoToAction implements Action{
    private int pos;
    
    public GoToAction(int pos){
        this.pos = pos;
    }
  
    @Override
    public void act(Refugee refugee){
        refugee.setPos(this.pos);
    }
    
    public void GoTo(int pos){
        this.pos = pos;
    }
    
    
}
