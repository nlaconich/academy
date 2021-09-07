package py.com.ci.academy.inscription.boundary;

import java.util.List;
import py.com.ci.academy.inscription.entities.Inscription;

public class InscriptionController {

    private InscriptionManager inscriptionManager = new InscriptionManager();

    public void addInscription(Inscription inscription) {
        int idInscription = inscriptionManager.addInscription(inscription);
    }

    public List<Inscription> getAll(){
        List<Inscription> inscriptions = inscriptionManager.getAll();
        return inscriptions;
    }
    
    public boolean updateInscription(Inscription inscription) {
        boolean ban = inscriptionManager.updateInscription(inscription);
        return ban;
    }
    
    public boolean deleteInscription(Inscription inscription) {
        boolean ban = inscriptionManager.deleteInscription(inscription);
        return ban;
    }
    
}
