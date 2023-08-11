package party.people.web.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {
    @NotEmpty
    private String clientId;
    @NotEmpty
    private String password;
}
