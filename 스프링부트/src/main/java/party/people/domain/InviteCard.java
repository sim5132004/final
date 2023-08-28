package party.people.domain;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.sql.Time;
import java.util.Date;

@Data
@Validated
public class InviteCard {

    private Long sequenceId;
    private String clientId;
    private Integer placeId1;
    private Integer placeId2;
    private Integer placeId3;
    private String title;
    private Date targatDate;
    private String targetTime;
    private String meetingContent;
    private String meetingParticipants;
    private String cardSkin;

}
