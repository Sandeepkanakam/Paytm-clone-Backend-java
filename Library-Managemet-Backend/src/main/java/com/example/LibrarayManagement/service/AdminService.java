package com.example.LibrarayManagement.service;

import com.example.LibrarayManagement.models.Admin;
import com.example.LibrarayManagement.models.User;
import com.example.LibrarayManagement.repository.AdminDao;
import com.example.LibrarayManagement.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    UserService userService;

    public void createAdmin(Admin admin) throws Exception {

        // Create user object

        User user = admin.getUser();
        user = userService.save(Constants.ADMIN_USER, user);

        if(user.getId() == null) {
            throw new Exception("Invalid User");
            // TODO - handle exception
        }

        admin.setUser(user);

        // Save it
        //add it to admin

        adminDao.save(admin);
    }

    public Admin findAdmin(Integer adminId) {
        return adminDao.findById(adminId).orElse(null);
    }



}
