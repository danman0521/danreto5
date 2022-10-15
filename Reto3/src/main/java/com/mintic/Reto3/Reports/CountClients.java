
package com.mintic.Reto3.Reports;

import com.mintic.Reto3.Model.Client;


public class CountClients {

   private long total;
   private Client client;
   
   public CountClients(Long total , Client client){
      
      this.total = total;
      this.client = client;
   }
   

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
