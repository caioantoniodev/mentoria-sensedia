package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.core.stave.domain.Stave;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindStave {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String ID_PROPERTY = "id";

    public Optional<Stave> find(Long id) {
        var query = new Query(Criteria.where(ID_PROPERTY).is(id));

        return  Optional.ofNullable(mongoTemplate.findOne(query, Stave.class));
    }
}
