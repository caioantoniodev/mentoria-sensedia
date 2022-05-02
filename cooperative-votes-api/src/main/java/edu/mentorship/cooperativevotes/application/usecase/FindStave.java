package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.core.domain.Stave;
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
    private static final String THEME_PROPERTY = "theme";
    private static final String STATE_PROPERTY = "state";

    public Optional<Stave> find(String id) {
        var query = new Query(Criteria.where(ID_PROPERTY).is(id));

        return  Optional.ofNullable(mongoTemplate.findOne(query, Stave.class));
    }

    public Optional<Stave> findByThemeAndStateIsSessionVotesDone(String theme) {

        Query query = new Query();

        query.addCriteria(Criteria.where(THEME_PROPERTY).is(theme));
        query.addCriteria(Criteria.where(STATE_PROPERTY).is("SESSION_VOTES_DONE"));

        return Optional.ofNullable(mongoTemplate.findOne(query, Stave.class));
    }
}
