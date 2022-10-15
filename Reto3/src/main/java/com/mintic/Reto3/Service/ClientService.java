package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientAll() {
        return clientRepository.getClientAll();
    }

    public Optional<Client> getClientId(Integer id) {
        return clientRepository.getClientId(id);
    }

    public Client saveClient(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.saveClient(client);
        } else {
            Optional<Client> clienteAuxiliar = clientRepository.getClientId(client.getIdClient());
            if (clienteAuxiliar.isEmpty()) {
                return clientRepository.saveClient(client);
            } else {
                return client;
            }
        }
    }
    public Client update(Client client){
            if(client.getIdClient()!=null){
                Optional<Client> clientAuxiliar = clientRepository.getClientId(client.getIdClient());
                if(!clientAuxiliar.isEmpty()){
                    if(client.getName()!=null){
                        clientAuxiliar.get().setName(client.getName());
                    }
                    if(client.getAge()!=null){
                        clientAuxiliar.get().setAge(client.getAge());
                    }
                    if(client.getPassword()!=null){
                        clientAuxiliar.get().setPassword(client.getPassword());
                    }
                    clientRepository.saveClient(clientAuxiliar.get());
                    return clientAuxiliar.get();
                }else{
                    return client;
                }
            }else{
                return client;
            }
        }

    public boolean deleteClient(Integer id){
            boolean flag=false;
            Optional<Client> clientAuxiliar = clientRepository.getClientId(id);
            if(clientAuxiliar.isPresent()){
                clientRepository.deleteSkate(clientAuxiliar.get());
                flag=true;
            }
            return flag;
        }

    
}
