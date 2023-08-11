package party.people.web.controller.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {
    /* HTML 로그인 단에서 제공받는 ID, PASSWORD를 담을 객체 생성용 클래스 */
    @NotEmpty
    private String clientId;
    @NotEmpty
    private String password;
}
