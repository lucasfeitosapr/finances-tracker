package br.com.gebotech.financestracker.repository.interfaces;

import br.com.gebotech.financestracker.models.RefreshToken;
import br.com.gebotech.financestracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Override
    Optional<RefreshToken> findById(Long id);
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
