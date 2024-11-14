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


    public RealmResource getRealmResource() {
        // 目前创建用户只会用admin，user 和 clients 都不太会
        Keycloak keycloak = Keycloak.getInstance(serverUrl, "master", "admin", "admin", "admin-cli");
        return keycloak.realm(realm);
    }
}
