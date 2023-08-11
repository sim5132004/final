package party.people.web.controller.client;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import party.people.domain.Client;
import party.people.repository.client.ClientInterface;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("client")
public class JoinController {

    private final ClientInterface clientInterface;

    @GetMapping("/join")
    public String joinForm(Client client, Model model){
        /* 체크 박스 메서드(최하단(메서드이름 컨트롤 클릭도 가능)에서 메서드 확인 가능) */
        /* 요약 : 체크박스 리스트를 thymeleaf단에 제공 */
        checkbox(model);
        log.info("joinForm] "+client);

        return "client/join";
    }



    @PostMapping("/join")
    public String join(@Valid @ModelAttribute Client client, BindingResult bindingResult, Model model,
                       @RequestParam(value = "selectedItems", required = false) List<String> selectedItems){

        /* 체크 박스 메서드(최하단(메서드이름 컨트롤 클릭도 가능)에서 메서드 확인 가능) */
        /* 요약 : 체크박스 리스트를 thymeleaf단에 제공 */
        checkbox(model);

        /* 체크리스트를 키워드에 담을 빈 변수 생성 */
        String regionKeywords = "";
        int count = 0;
        if (selectedItems!=null) {
            /* 체크박스 선택된 리스트를 위 변수에 입력 */
            for (String regionKeyword : selectedItems) {
                if (count == 0) {
                    regionKeywords = regionKeywords + regionKeyword;
                } else {
                    regionKeywords = regionKeywords + "," + regionKeyword;
                }
                count++;
            }
            log.info("체크리스트 확인 " + regionKeywords);
        }


        /* 체크리스트 키워드를 keyword에 추가 */
        client.setKeyword(regionKeywords);
        log.info("클라이언트 객체 확인 "+client);

        /* 아이디 중복 검사 */
        Client duplicateId = clientInterface.findByClientId(client.getClientId()).orElse(null);
        if (duplicateId!=null){
            bindingResult.rejectValue("clientId","clientId.invalid","해당 ID는 이미 존재합니다");
            return "client/join";
        }

        /* 비밀번호, 비밀번호2 일치 확인 */
        Boolean pass = (client.getPassword()).equals(client.getPassword2());
        if (!pass){
            bindingResult.rejectValue("password2","password2.invalid","두 비밀번호가 일치하지 않습니다.");
            return "client/join";
        }

        /* Validation 체크 => 밸리데이션 오류시 join페이지로 리턴 오류메시지(client domain 확인) 출력 */
        if(bindingResult.hasErrors()) {
            return "client/join";
        }

        /* Validation 오류 없으면 DB에 CLIENT 객체를 저장 */
        clientInterface.save(client);

        /* 저장 완료 후 초기 홈페이지로 이동 */
        return "redirect:/";

    }

    /* 체크박스 메서드화 */
    private static void checkbox(Model model) {
        /* CHECKBOX리스트를 동적 생성하기 위한 리스트 생성 */
        List<String> regionCheckbox = Arrays.asList("연수구","남동구","부평구","계양구","서구","동구","중구","미추홀구","강화군","옹진군");
        /* 체크박스 LIST를 THYMELEAF단으로 전송 */
        model.addAttribute("regionCheckbox", regionCheckbox);

        /* 위와 동일 */
        List<String> interestCheckbox = Arrays.asList("관광","자연","레저","쇼핑","음식","숙박","문화");
        model.addAttribute("interestCheckbox", interestCheckbox);
    }



}
