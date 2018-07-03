/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ellen
 */
@Entity
@Table(name = "cavalo")
@NamedQueries({
    @NamedQuery(name = "Cavalo.findAll", query = "SELECT c FROM Cavalo c")})
public class Cavalo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cavalo")
    private String idCavalo;
    @Column(name = "marca")
    private String marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cavaloIdCavalo")
    private List<Caminhao> caminhaoList;

    public Cavalo() {
    }

    public Cavalo(String idCavalo) {
        this.idCavalo = idCavalo;
    }

    public String getIdCavalo() {
        return idCavalo;
    }

    public void setIdCavalo(String idCavalo) {
        this.idCavalo = idCavalo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Caminhao> getCaminhaoList() {
        return caminhaoList;
    }

    public void setCaminhaoList(List<Caminhao> caminhaoList) {
        this.caminhaoList = caminhaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCavalo != null ? idCavalo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cavalo)) {
            return false;
        }
        Cavalo other = (Cavalo) object;
        if ((this.idCavalo == null && other.idCavalo != null) || (this.idCavalo != null && !this.idCavalo.equals(other.idCavalo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cavalo[ idCavalo=" + idCavalo + " ]";
    }
    
}
