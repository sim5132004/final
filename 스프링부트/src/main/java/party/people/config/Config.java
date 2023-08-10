package party.people.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import party.people.repository.client.ClientInterface;
import party.people.repository.client.ClientMapper;
import party.people.repository.client.ClientRepository;
import party.people.repository.test.TestInterface;
import party.people.repository.test.TestMapper;
import party.people.repository.test.TestRepository;
import party.people.service.login.LoginInterface;
import party.people.service.login.LoginService;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final TestMapper testMapper;
    private final ClientMapper clientMapper;



    @Bean
    public TestInterface testInterface(){
        return new TestRepository(testMapper);
    }

    @Bean
    public ClientInterface clientInterface(){
        return new ClientRepository(clientMapper);
    }

    @Bean
    public LoginInterface loginInterface(){
        return new LoginService(clientInterface());
    }

}
