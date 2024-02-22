package event;

import model.Model_Register;
import model.Model_seDeconnecter;
import model.Model_seconnecter;

public interface EventLogin {

    public void seConnecter(Model_seconnecter data);
    
    public void seDeConnecter(Model_seDeconnecter data);

    public void creerCompte(Model_Register data, EventMessage message );

    public void retourSeconnecter();

    public void retourCreerCompte();
}
