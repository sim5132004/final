package party.people.repository.client;

import lombok.Data;

@Data
public class ClientUpdateDto {
    private String password;
    private String clientEmail;

    public ClientUpdateDto(){}

    public ClientUpdateDto(String password, String clientEmail) {
        this.password = password;
        this.clientEmail = clientEmail;
    }
}
