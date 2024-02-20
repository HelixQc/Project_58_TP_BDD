package oscar.awardService.persistence;

import oscar.awardService.model.Award;

import java.awt.*;
import java.util.List;
// Contract definition for CRUD Operations
public interface IAwardDAO {

    public Award findAwardByName(String name);
    public List<Award> findAll();

}
