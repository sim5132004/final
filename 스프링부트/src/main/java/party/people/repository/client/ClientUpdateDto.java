package party.people.repository.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class ClientUpdateDto {
    /* 회원 정보 수정을 위한 DTO 도메인 */
    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    @Size(min=4, message = "비밀번호는 최소 4글자 이상이어야 합니다.")
    private String password;
    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    @Size(min=4, message = "비밀번호는 최소 4글자 이상이어야 합니다.")
    private String password2;
    @NotBlank
    @Email
    private String clientEmail;
    private String keyword;

    public ClientUpdateDto(){}

    public ClientUpdateDto(String password, String clientEmail, String keyword) {
        this.password = password;
        this.clientEmail = clientEmail;
        this.keyword = keyword;
    }
}
