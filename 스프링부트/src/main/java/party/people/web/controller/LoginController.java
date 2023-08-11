package party.people.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import party.people.domain.Client;
import party.people.repository.client.ClientInterface;
import party.people.service.login.LoginInterface;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginInterface loginInterface;
    private final ClientInterface clientInterface;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        List<Client> test = clientInterface.findAll();
        log.info("loginForm] "+test);
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, Model model){
        Client login = loginInterface.login(form.getClientId(), form.getPassword());
        log.info("login] "+login);
        model.addAttribute("client",login);

        if (login == null) {
            return "login/loginForm";
        }

        return "redirect:/loginHome";
    }

}
