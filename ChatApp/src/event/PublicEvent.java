package event;

public class PublicEvent { 
    private static PublicEvent instance;
    private EventImageView eventImageView;
    private EventChat eventChat;
    private EventLogin eventLogin;
    private EventMain eventMain;
    private EventMenuGauche eventMenuGauche;

    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() {

    }

    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }
       
    public void addEventChat(EventChat event){
        this.eventChat = event;
    }
    public void addEventLogin(EventLogin event){
        this.eventLogin = event;
    }
    public void addEventMain(EventMain event){
        this.eventMain = event;
    }
    public void addEventMenuGauche(EventMenuGauche event){
        this.eventMenuGauche = event;
    }

    public EventImageView getEventImageView() {
        return eventImageView;
    }
 
    public EventChat getEventChat(){
        return eventChat;
    }
    
    public EventLogin getEventLogin(){
        return eventLogin;
    }
    public EventMain getEventMain(){
        return eventMain;
    }
    public EventMenuGauche getEventMenuGauche(){
        return eventMenuGauche;
    }
    
}
