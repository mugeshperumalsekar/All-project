package com.ponsun.aml.banktransaction.accountDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails,Integer> {
    Optional<AccountDetails> findById(Integer id);
}