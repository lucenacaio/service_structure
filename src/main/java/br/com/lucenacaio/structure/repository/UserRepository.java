package br.com.lucenacaio.structure.repository;

import br.com.lucenacaio.structure.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
