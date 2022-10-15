package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Skate;
import com.mintic.Reto3.Repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getSkateAll() {
        return skateRepository.getSkateAll();

    }

    public Optional<Skate> getSkateId(Integer id) {
        return skateRepository.getSkateid(id);
    }

    public Skate saveSkate(Skate skate) {
        if (skate.getId() == null) {
            return skateRepository.saveSkate(skate);
        } else {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateid(skate.getId());
            if (skateAuxiliar.isEmpty()) {
                return skateRepository.saveSkate(skate);
            } else {
                return skate;
            }
        }
    }

    public Skate update(Skate skate) {
        if (skate.getId() != null) {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateid(skate.getId());
            if (!skateAuxiliar.isEmpty()) {
               if(skate.getName()!=null){
                        skateAuxiliar.get().setName(skate.getName());
                    }
                    if(skate.getYear()!=null){
                        skateAuxiliar.get().setYear(skate.getYear());
                    }
                    if(skate.getBrand()!=null){
                        skateAuxiliar.get().setBrand(skate.getBrand());
                    }
                    if(skate.getDescription()!=null){
                        skateAuxiliar.get().setDescription(skate.getDescription());
                    }
                    if(skate.getCategory()!=null){
                        skateAuxiliar.get().setCategory(skate.getCategory());
                    }    
                    skateRepository.saveSkate(skateAuxiliar.get());
                    return skateAuxiliar.get();
                } else {
                    return skate;
                }
            } else {
                return skate;
            }
        }    

    
    public boolean deleteSkate(Integer skateId) {
        boolean flag = false;
        Optional<Skate> skateAuxiliar = skateRepository.getSkateid(skateId);
        if (skateAuxiliar.isPresent()) {
            skateRepository.deleteSkate(skateAuxiliar.get());
            flag = true;
        }
        return flag;
    }

}
