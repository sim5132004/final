package party.people.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import party.people.repository.client.ClientInterface;
import party.people.repository.client.ClientMapper;
import party.people.repository.client.ClientRepository;
import party.people.repository.place.PlaceInterface;
import party.people.repository.place.PlaceMapper;
import party.people.repository.place.PlaceRepository;
import party.people.repository.test.TestInterface;
import party.people.repository.test.TestMapper;
import party.people.repository.test.TestRepository;
import party.people.service.client.ClientKeywords;
import party.people.service.login.LoginInterface;
import party.people.service.login.LoginService;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final TestMapper testMapper;
    private final ClientMapper clientMapper;
    private final PlaceMapper placeMapper;


    /* DB접속 TEST용 BEAN */
    @Bean
    public TestInterface testInterface(){
        return new TestRepository(testMapper);
    }

    /* 회원관리용 BEAN */
    @Bean
    public ClientInterface clientInterface(){
        return new ClientRepository(clientMapper);
    }

    /* 로그인용 BEAN -> 클라이언트 인터페이스와 연결 */
    @Bean
    public LoginInterface loginInterface(){
        return new LoginService(clientInterface());
    }

    @Bean
    public ClientKeywords clientKeywords() {
        return new ClientKeywords(clientInterface());
    }

    /* Place 검색용 BEAN */
    @Bean
    public PlaceInterface placeInterface() {
        return new PlaceRepository(placeMapper);
    }
}
