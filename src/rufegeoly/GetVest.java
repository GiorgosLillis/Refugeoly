package rufegeoly;

public class GetVest implements Action{
    
    public GetVest(){
    
    }
    
    @Override
    public void act(Refugee refugee) {
       refugee.getJacket(true);
    }
}
