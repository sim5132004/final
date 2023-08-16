package party.people.web.controller.client;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import party.people.domain.Client;
import party.people.repository.client.ClientInterface;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MyInfoController {

    private final ClientInterface clientInterface;

    @GetMapping("myInfo")
    public String myInfoForm(Model model, Client client, HttpServletRequest request){
        HttpSession loginInfo = request.getSession(false);

        Client loginClient = (Client) loginInfo.getAttribute("로그인");

        return "client/myInfo";
    }
}
