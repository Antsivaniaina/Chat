package event;

import java.util.List;
import model.Model_utilisateur;

public interface EventMenuGauche {
    public void nouveauUtilisateur(List<Model_utilisateur> utilisateur);
    public void utilisateurConnexion(int utilisateurID);
    public void utilisateurDeconnexion(int utilisateurID);
}
