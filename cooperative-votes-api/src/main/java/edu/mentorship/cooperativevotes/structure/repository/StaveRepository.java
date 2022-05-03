package edu.mentorship.cooperativevotes.structure.repository;

import edu.mentorship.cooperativevotes.core.stave.domain.Stave;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaveRepository extends MongoRepository<Stave, String> {

    Boolean existsStaveByThemeAndState(String theme, String state);
}
