package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Admin;
import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdminAll() {
        return adminRepository.getAdminAll();
    }

    public Optional<Admin> getAdminId(Integer id) {
        return adminRepository.getAdminId(id);
    }

    public Admin saveAdmin(Admin admin) {
        if (admin.getIdAdmin()== null) {
            return adminRepository.saveAdmin(admin);
        } else {
            Optional<Admin> adminAuxiliar = adminRepository.getAdminId(admin.getIdAdmin());
            if (adminAuxiliar.isEmpty()) {
                return adminRepository.saveAdmin(admin);
            } else {
                return admin
                        ;
            }
        }
    }
    
}
