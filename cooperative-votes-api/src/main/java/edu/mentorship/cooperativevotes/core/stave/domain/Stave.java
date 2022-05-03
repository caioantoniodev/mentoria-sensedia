package edu.mentorship.cooperativevotes.core.stave.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "stave")
public class Stave {

    private String id;

    private String theme;

    private String description;

    private String state;

    private LocalDateTime startSessionVoting;

    private Long timeToLeaveSession;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private int totalVotesYes;

    private int totalVotesNo;

    private int totalVoteInvalid;

    public void createAt() {
        createAt = LocalDateTime.now();
        updateAt();
    }

    public void updateAt() {
        updateAt = LocalDateTime.now();
    }
}
