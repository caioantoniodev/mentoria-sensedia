package edu.mentorship.cooperativevotes.core.stave.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@Document(collection = "stave")
public class Stave {

    @Id
    private long id;

    private String theme;

    private String description;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
//
//    private String state;
//
//    private LocalDateTime startSessionVoting;
//
//    private Long timeToLeaveSession;
//
//    private LocalDateTime createAt;
//
//    private LocalDateTime updateAt;
//
//    private int totalVotesYes;
//
//    private int totalVotesNo;
//
//    private int totalVoteInvalid;
}
