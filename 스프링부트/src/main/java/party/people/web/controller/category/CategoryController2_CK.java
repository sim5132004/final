package party.people.web.controller.category;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.InviteCard;
import party.people.domain.Place;
import party.people.repository.InviteCard.InviteCardInterface;
import party.people.repository.place.PlaceInterface;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static party.people.web.controller.category.CategoryController.loginCheck;

@Controller
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class CategoryController2_CK {

    private final PlaceInterface placeInterface;
    private final InviteCardInterface inviteCardInterface;




    @GetMapping("invite")
    public String goInvite(HttpServletRequest request, Model model){

        Random random = new Random();

        /* 로그인 세션 유지용 메서드 */
        /* 메서드 이름 컨트롤 클릭으로 내용 확인 가능 */
        loginCheck(request,model);

        /* side lnb 출력용 */
        model.addAttribute("category","invite");

        int randomNumber1 = random.nextInt(1,10);

        int randomNumber2 = random.nextInt(1,800);

        int randomNumber3 = random.nextInt(1, 800);


        List<Place> placeList2 = new ArrayList<>();
        Place place12 = placeInterface.idSearch(randomNumber1);
        /* 이미지 다운로드용 에러방지 이미지 주소를 변환 인코딩 */
        placeImageToBinary(place12);
        Place place22 = placeInterface.idSearch(randomNumber2);
        placeImageToBinary(place22);
        Place place32 = placeInterface.idSearch(randomNumber3);
        placeImageToBinary(place32);
        placeList2.add(place12);
        placeList2.add(place22);
        placeList2.add(place32);

        place12.keyWord5();


        /* 플레이스에서 보내져온 리스트 확인용 세션 */
        HttpSession test = request.getSession(false);
        /* 플레이스 리스트 객체를 담을 전역(컨트롤러 한정) 리스트변수 생성 */
        List<Place>place2 = new ArrayList<>();

        /* 세션 값이 있을 경우 이하 구문 실행 */
        if (test!=null) {

            /* 세션 중 플레이스에서 보내온 세션이 있는지 확인하고 있으면 플레이스 리스트 객체에 저장 */

            /* 키값을 "검색결과" 로 받아오면 인바이트에서 List<Place>가 아니라
               List<List<Place>를 받아오는 경우에 에러가 생겨서
                세션 키값을 검색결과와 선택결과로 분리 */
            place2 = (List<Place>) test.getAttribute("선택결과");

            /* 그냥 Invite페이지에 왔을때를 위해 선택결과 세션 초기화 */
            test.setAttribute("선택결과",null);
            log.info("세션에서 받아온 정보 확인 "+place2);
            /* "검색결과"키로 세션 정보를 받은 경우 */
            if (place2 != null) {
                /* 이미지 주소 다운 에러 방지용 base64타입 인코딩 객체를 담을 리스트 생성 */
                List<Place>newImageAddPlace = new ArrayList<>();

                /* 각 객체의 이미지 주소를 다운로드 시 에러방지용으로 base64타입으로 인코딩 */
                for (Place obj : place2){
                    placeImageToBinary(obj);
                    newImageAddPlace.add(obj);
                }
                Place pl = newImageAddPlace.get(0);

                /* 해당 리스트를 타임리프단으로 전달 */
                model.addAttribute("category2", newImageAddPlace);
                /* 인바이트 제목내용 전달 */
                model.addAttribute("keylist",pl.keyWordTitle());
            /* 세션 정보가 없을 경우 랜덤생성된 리스트 타임리프로 전달 */
            } else model.addAttribute("category2",placeList2);

        }
        /* 세션 정보가 없을 경우 랜덤생성된 리스트 타임리프로 전달 */
        else{
            model.addAttribute("category2", placeList2);
            log.info("NULL !!!!");
        }




        return "invite/invite_A";
    }

    /* 이미지 다운로드 에러 방지용 객체 이미지주소 바이너리 타입으로 인코딩 후 객체 다시 저장 */
    private static void placeImageToBinary(Place place12) {
        String change = place12.getImageAdd1();
        try {
            // 이미지 다운로드
            URL url = new URL(change);
            InputStream in = url.openStream();
            Path tempImage = Files.createTempFile("image", ".jpg");
            Files.copy(in, tempImage, StandardCopyOption.REPLACE_EXISTING);

            // 이미지 데이터를 Base64로 인코딩
            byte[] imageBytes = Files.readAllBytes(tempImage);
            String base64Encoded = Base64.getEncoder().encodeToString(imageBytes);

            // 데이터 URI 형식 생성
            String dataUri = "data:image/jpeg;base64," + base64Encoded;
            place12.setImageAdd1(dataUri);

            // 임시 파일 삭제
            Files.delete(tempImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/saveCard")
    public String resultPage(@RequestParam("data") String data, @ModelAttribute("card") InviteCard inviteCard) {

        inviteCardInterface.saveCard(inviteCard);


//        model.addAttribute("data", data);



        return "";
    }



}
