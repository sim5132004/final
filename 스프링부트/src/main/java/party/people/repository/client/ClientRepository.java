package party.people.repository.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import party.people.domain.Client;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClientRepository implements ClientInterface{

    private final ClientMapper clientMapper;

    @Override
    public Client save(Client client) {
        clientMapper.save(client);
        return client;
    }

    @Override
    public List<Client> findAll() {
        return clientMapper.findAll();
    }

    @Override
    public Optional<Client> findBySequenceId(Long sequenceId) {
        return clientMapper.findBySequenceId(sequenceId);
    }

    @Override
    public Optional<Client> findByClientId(String clientId) {
        log.info("findByClientId] "+clientId);
        return clientMapper.findByClientId(clientId);
    }

    @Override
    public Optional<Client> findPassword(String clientId, String clientEmail) {
        return clientMapper.findPassword(clientId, clientEmail);
    }

    @Override
    public void update(String clientId, ClientUpdateDto clientUpdateParam) {
        clientMapper.update(clientId, clientUpdateParam);
    }
}
