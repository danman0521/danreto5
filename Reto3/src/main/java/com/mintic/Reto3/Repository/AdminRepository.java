
package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Admin;
import com.mintic.Reto3.Repository.Crud.AdminCrudRepositoryInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
     @Autowired
    private AdminCrudRepositoryInterfaz adminCrudRepositoryInterfaz;
    
    public List <Admin> getAdminAll(){
        return (List<Admin>) adminCrudRepositoryInterfaz.findAll();
    }
    
    public Optional <Admin> getAdminId(Integer id){
        return adminCrudRepositoryInterfaz.findById(id);
    
    }
    
    public Admin saveAdmin(Admin admin){
    return adminCrudRepositoryInterfaz.save(admin);
    }
    
}
