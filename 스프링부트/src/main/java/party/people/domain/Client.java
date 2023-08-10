package party.people.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Client {
    private Long sequenceId;
    @NotBlank(message = "ID는 필수 입력 사항입니다.")
    private String clientId;
    @NotBlank(message = "Password는 필수 입력 사항입니다.")
    @Size(min=4, message = "Password는 최소 4글자 이상이어야 합니다.")
    private String password;
    @NotBlank
    @Email
    private String clientEmail;
    private String keyword;

    public Client(){}

    public Client(String clientId, String password, String clientEmail, String keyword) {
        this.clientId = clientId;
        this.password = password;
        this.clientEmail = clientEmail;
        this.keyword = keyword;
    }
}
