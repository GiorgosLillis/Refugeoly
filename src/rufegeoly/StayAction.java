package rufegeoly;

public class StayAction implements Action{
    private int stay;
    
    public StayAction(int stay){
        this.stay = stay;
    }
    
    @Override
    public void act(Refugee refugee) {
       refugee.setStay(this.stay);
    }
    
}
