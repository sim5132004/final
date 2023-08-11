package party.people.repository.client;

import lombok.Data;

@Data
public class ClientUpdateDto {
    /* 회원 정보 수정을 위한 DTO 도메인 */
    private String password;
    private String clientEmail;

    public ClientUpdateDto(){}

    public ClientUpdateDto(String password, String clientEmail) {
        this.password = password;
        this.clientEmail = clientEmail;
    }
}
