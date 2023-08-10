package party.people.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import party.people.repository.test.TestInterface;
import party.people.repository.test.TestMapper;
import party.people.repository.test.TestRepository;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final TestMapper testMapper;

    @Bean
    public TestInterface testInterface(){
        return new TestRepository(testMapper);
    }

}
