package com.portafolio.registrousuarios.repository;

import com.portafolio.registrousuarios.model.RegistroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroUsuarioRepository extends JpaRepository<RegistroUsuario, Long> {
}
