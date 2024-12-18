package com.wggt.core_bank_service.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;
    private List<BankAccount> bankAccounts;
}
