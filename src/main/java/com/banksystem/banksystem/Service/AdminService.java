package com.banksystem.banksystem.Service;

import com.banksystem.banksystem.Entity.Admin;
import com.banksystem.banksystem.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired private AdminRepository adminRepo;

    public Optional<Admin> login(String username, String password) {
        Optional<Admin> admin = adminRepo.findByUsername(username);
        return admin.filter(a -> a.getPasswordHash().equals(password));
    }

    public void createAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public void deleteAdmin(int id) {
        adminRepo.deleteById(id);
    }

    public Optional<Admin> getAdminById(int id) {
        return adminRepo.findById(id);
    }

    public void updateAdmin(Admin admin) {
        adminRepo.save(admin);
    }
}

