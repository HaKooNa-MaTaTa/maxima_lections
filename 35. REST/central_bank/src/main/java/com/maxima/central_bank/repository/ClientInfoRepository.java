package com.maxima.central_bank.repository;

import com.maxima.central_bank.model.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientInfoRepository extends JpaRepository<ClientInfo, Long> {

}

