/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.Embeddable;



@Embeddable
public class LigneCommandeProduitId implements Serializable {
    private int commandeId;
    private int produitId;

    public LigneCommandeProduitId() {}

    public LigneCommandeProduitId(int commandeId, int produitId) {
        this.commandeId = commandeId;
        this.produitId = produitId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }
}
    
