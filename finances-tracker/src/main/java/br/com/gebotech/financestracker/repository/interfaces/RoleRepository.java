package br.com.gebotech.financestracker.repository.interfaces;

import br.com.gebotech.financestracker.models.Role;
import br.com.gebotech.financestracker.models.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role>findByName(ERole name);

}
