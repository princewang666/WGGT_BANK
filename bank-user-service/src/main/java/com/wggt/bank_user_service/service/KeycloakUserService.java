package com.wggt.bank_user_service.service;

import java.util.List;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wggt.bank_user_service.config.keycloak.KeycloakManager;
import com.wggt.bank_user_service.exception.EntityNotFoundException;

import jakarta.ws.rs.core.Response;

@Service
public class KeycloakUserService {
    @Autowired
    private KeycloakManager keycloakManager;

    public Integer createUser(UserRepresentation userRepresentation) {
        Response response = keycloakManager.getRealmResource().users().create(userRepresentation);
        return response.getStatus();
    }

    public void updateUser(UserRepresentation userRepresentation) {
        keycloakManager.getRealmResource().users().get(userRepresentation.getId()).update(userRepresentation);
    }

    public List<UserRepresentation> readUserByEmail(String email) {
        return keycloakManager.getRealmResource().users().search(email);
    }

    public UserRepresentation readUser(String authId) {
        try {
            UserResource userResource = keycloakManager.getRealmResource().users().get(authId);
            return userResource.toRepresentation();
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found under given ID");
        }
    }
}
