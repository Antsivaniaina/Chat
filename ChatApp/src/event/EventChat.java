package event;

import model.Model_Envoie_Message;
import model.Model_Recoit_Message;

public interface EventChat {

    public void envoyerMessage(Model_Envoie_Message data);
    public void reçoitMessage(Model_Recoit_Message data);
}
