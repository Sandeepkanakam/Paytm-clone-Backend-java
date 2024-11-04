package com.example.LibrarayManagement.repository;

import com.example.LibrarayManagement.models.Book;
import com.example.LibrarayManagement.models.Student;
import com.example.LibrarayManagement.models.Transaction;
import com.example.LibrarayManagement.models.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Integer> {

    Transaction findTransactionByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student,
                                                                               Book book,
                                                                               TransactionType transactionType);


}
