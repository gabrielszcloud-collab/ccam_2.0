package com.ccam.ccamv2.repository;

import com.ccam.ccamv2.model.Mural;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface MuralRepository extends JpaRepository<Mural, UUID> {
    // Traz os avisos mais recentes primeiro (Order By)
    List<Mural> findAllByOrderByDataPublicacaoDesc();
}