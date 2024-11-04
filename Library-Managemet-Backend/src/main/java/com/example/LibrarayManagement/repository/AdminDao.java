package com.example.LibrarayManagement.repository;

import com.example.LibrarayManagement.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Integer> {
}
