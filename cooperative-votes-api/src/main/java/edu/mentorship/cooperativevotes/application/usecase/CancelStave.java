package edu.mentorship.cooperativevotes.application.usecase;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CancelStave {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final FindStave findStave;

    public void cancelStave(String id) {
        var staveOptional = findStave.find(id);

        if (!staveOptional.isPresent())
            throw new RuntimeException();

        var entity = staveOptional.get();

        if (entity.getState().equalsIgnoreCase("CREATE") ||
                entity.getState().equalsIgnoreCase("VOTING_IN_PROGRESS")) {
            // Todo
        }
    }
}
