package party.people.service.login;

import party.people.domain.Client;

public interface LoginInterface {

    Client login(String clientId, String password);
}
