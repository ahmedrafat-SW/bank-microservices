package org.rafat.dev.loans.repository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.rafat.dev.loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByMobileNumber(String mobileNumber);

    Optional<Loan> findByLoanNumber(@NotEmpty(message = "Loan Number can not be a null or empty")
                                      @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
                                      String loanNumber);
}
