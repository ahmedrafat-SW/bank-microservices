package org.rafat.dev.cards.dao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.rafat.dev.cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByCardNumber(@NotEmpty(message = "Card Number can not be a null or empty")
                                    @Pattern(regexp="(^$|[0-9]{12})",message = "CardNumber must be 12 digits")
                                    String cardNumber);

    Optional<Card> findByMobileNumber(String mobileNumber);
}
