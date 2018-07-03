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
@Table(name = "carreta")
@NamedQueries({
    @NamedQuery(name = "Carreta.findAll", query = "SELECT c FROM Carreta c")})
public class Carreta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_carreta")
    private String idCarreta;
    @Basic(optional = false)
    @Column(name = "capacidade_max")
    private double capacidadeMax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carretaIdCarreta")
    private List<Caminhao> caminhaoList;

    public Carreta() {
    }

    public Carreta(String idCarreta) {
        this.idCarreta = idCarreta;
    }

    public Carreta(String idCarreta, double capacidadeMax) {
        this.idCarreta = idCarreta;
        this.capacidadeMax = capacidadeMax;
    }

    public String getIdCarreta() {
        return idCarreta;
    }

    public void setIdCarreta(String idCarreta) {
        this.idCarreta = idCarreta;
    }

    public double getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(double capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
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
        hash += (idCarreta != null ? idCarreta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carreta)) {
            return false;
        }
        Carreta other = (Carreta) object;
        if ((this.idCarreta == null && other.idCarreta != null) || (this.idCarreta != null && !this.idCarreta.equals(other.idCarreta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Carreta[ idCarreta=" + idCarreta + " ]";
    }
    
}
