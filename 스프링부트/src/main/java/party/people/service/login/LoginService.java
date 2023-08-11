package party.people.service.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import party.people.domain.Client;
import party.people.repository.client.ClientInterface;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginInterface{

    private final ClientInterface clientInterface;

    @Override
    public Client login(String clientId, String password) {
        return clientInterface.findByClientId(clientId)
                .filter(p->p.getPassword().equals(password))
                .orElse(null);
    }
}
