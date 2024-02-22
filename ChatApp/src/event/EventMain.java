package event;

import model.Model_utilisateur;

public interface EventMain {

    public void showLoading(boolean show);

    public void initChat();
    public void endChat();
    public void selectUtilisateur(Model_utilisateur utilisateur);
    public void majUtilisateur(Model_utilisateur utilisateur); 
}
