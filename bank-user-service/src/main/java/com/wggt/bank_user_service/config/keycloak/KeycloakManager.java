package com.wggt.bank_user_service.config.keycloak;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeycloakManager {
    @Value("${keycloak.config.serverUrl}")
    private String serverUrl;
    @Value("${keycloak.config.realm}")
    private String realm;
    @Value("${keycloak.config.username}")
    private String username;
    @Value("${keycloak.config.password}")
    private String password;
    @Value("${keycloak.config.clientId}")
    private String clientId;
    @Value("${keycloak.config.clientSecret}")
    private String clientSecret;

    public RealmResource getRealmResource() {
        Keycloak keycloak = Keycloak.getInstance(serverUrl, realm, username, password, clientId, clientSecret);
        return keycloak.realm(realm);
    }
}
