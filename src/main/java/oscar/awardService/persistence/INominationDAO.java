package oscar.awardService.persistence;

import oscar.awardService.model.Nomination;

import java.util.List;

public interface INominationDAO {
    public Nomination findNominationById();
    public List<Nomination> findAll();
}
