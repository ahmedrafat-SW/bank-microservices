package org.rafat.dev.loans.mapper;

import org.rafat.dev.loans.dto.LoanDto;
import org.rafat.dev.loans.model.Loan;

public class LoanMapper {

    public static LoanDto mapToLoansDto(Loan loan, LoanDto dto) {
        dto.setLoanNumber(loan.getLoanNumber());
        dto.setLoanType(loan.getLoanType());
        dto.setMobileNumber(loan.getMobileNumber());
        dto.setTotalLoan(loan.getTotalLoan());
        dto.setAmountPaid(loan.getAmountPaid());
        dto.setOutstandingAmount(loan.getOutstandingAmount());
        return dto;
    }

    public static Loan mapToLoan(LoanDto dto, Loan loan) {
        loan.setLoanNumber(dto.getLoanNumber());
        loan.setLoanType(dto.getLoanType());
        loan.setMobileNumber(dto.getMobileNumber());
        loan.setTotalLoan(dto.getTotalLoan());
        loan.setAmountPaid(dto.getAmountPaid());
        loan.setOutstandingAmount(dto.getOutstandingAmount());

        return loan;
    }
}
