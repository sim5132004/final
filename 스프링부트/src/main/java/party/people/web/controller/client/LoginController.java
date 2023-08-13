package party.people.web.controller.client;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginInterface loginInterface;
    private final ClientInterface clientInterface;

    /* Thymeleaf onclick:login 수행시 페이지 이동*/
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    /* 로그인 기능 수행 */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, Model model, HttpServletRequest request){
        /* html단에서 입력받은 id, password를 사용해 DB에 있는지 확인 */
        Client login = loginInterface.login(form.getClientId(), form.getPassword());
        /* login 객체는 DB에 일치하는 정보가 있으면 Client 객체 반환, 일치 정보가 없으면 null 반환 */
        log.info("login] "+login);
        /* html단에 login객체 전송  */
        model.addAttribute("client",login);

        /* DB에 일치하는 정보가 없으면 로그인창으로 다시 이동 */
        if (login == null) {
            return "login/loginForm";
        }


        /* logininfo로 세션 객체 생성 */
        HttpSession loginInfo = request.getSession();
        /* "로그인"으로 호출하면 Client login 객체 로딩 */
        loginInfo.setAttribute("로그인",login);



        /* DB에 일치하는 정보가 있으면 로그인 성공 페이지로 이동 */
        return "redirect:/";
    }

}
