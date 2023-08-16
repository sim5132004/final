package party.people.repository.client;

import lombok.Data;

@Data
public class ClientUpdateDto {
    /* 회원 정보 수정을 위한 DTO 도메인 */
    private String password;
    private String clientEmail;
    private String keyword;

    public ClientUpdateDto(){}

    public ClientUpdateDto(String password, String clientEmail, String keyword) {
        this.password = password;
        this.clientEmail = clientEmail;
        this.keyword = keyword;
    }
}
