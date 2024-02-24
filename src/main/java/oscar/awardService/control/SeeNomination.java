package oscar.awardService.control;

import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.NominationDAO;
import oscar.awardService.persistence.NominationDAO_DB;

import java.util.List;

/**
 * As a film historian,
 * I want to see all nomination
 * categories and respective winners,
 * so I can look for trends and
 * statistics in film awards.
 */
public class SeeNomination {

    NominationDAO nominationDAO = new NominationDAO();
    NominationDAO_DB nominationDAO_db = new NominationDAO_DB();

    public List<Nomination> consultNominationInMemoryRepository(){
        return nominationDAO.findAllNomination();
    }

    public List<Nomination> consultNominationJDBC(){
        return nominationDAO_db.findAllNomination();
    }

    public List<Nomination>consultWinner(){
        return null;
    }
}
