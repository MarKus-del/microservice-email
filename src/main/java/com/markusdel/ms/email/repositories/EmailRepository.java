package com.markusdel.ms.email.repositories;

import com.markusdel.ms.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository  extends JpaRepository<EmailModel, Long> {}
