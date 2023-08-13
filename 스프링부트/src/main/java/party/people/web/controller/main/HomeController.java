package party.people.web.controller.main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import party.people.domain.Client;
import party.people.domain.Test;
import party.people.repository.test.TestInterface;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    /* DB 접속 확인용 인터페이스*/
    private final TestInterface testInterface;


    /* home */
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model){
        /* 세션 정보 가져오기 */
        /* create:false => 세션 정보가 있으면 기존 세션정보 로딩, 없으면 null 반환 */
        /* 세션 생성은 LoginController 참조 */
        HttpSession loginInfo =request.getSession(false);
        log.info("세션정보 " + loginInfo);

        /* 기존 세션 정보가 없으면 home으로 이동 */
        if (loginInfo==null){
            return "home";
        }

        /* 세션 정보 "로그인"으로 세션 정보를 호출해 Client loginClient 객체를 생성 */
        /* LoginController에서 확인 가능 */
        Client loginClient = (Client) loginInfo.getAttribute("로그인");
        log.info("로그인이 되었는가" + loginClient);
        /* 해당 객체가 없다면 home으로 이동 */
        if (loginClient==null){
            return "home";
        }
        log.info("home] "+loginClient);
        /* 세션에 저장되어있는 로그인 정보를 thymeleaf단에 "client"이름으로 전달 */
        model.addAttribute("client",loginClient);

        /* Oracle 데이터베이스 연결 확인 */
        List<Test> test = testInterface.findAll();

        /* 세션 객체(로그인 정보)가 null이 아니라면 loginHome으로 이동 */
        return "loginHome";
    }

}
