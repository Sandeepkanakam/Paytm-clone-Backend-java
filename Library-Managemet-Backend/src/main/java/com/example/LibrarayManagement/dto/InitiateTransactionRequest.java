package com.example.LibrarayManagement.dto;

import com.example.LibrarayManagement.models.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InitiateTransactionRequest {

    @NotNull
    private String studentRollNumber;
    @NotNull
    private Integer bookId;
    @NotNull
    private Integer adminId;
    @NotNull
    private TransactionType transactionType;





}
