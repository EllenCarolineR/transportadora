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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ellen
 */
@Entity
@Table(name = "caminhao")
@NamedQueries({
    @NamedQuery(name = "Caminhao.findAll", query = "SELECT c FROM Caminhao c")})
public class Caminhao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_caminhao")
    private Integer idCaminhao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caminhaoIdCaminhao")
    private List<Transporte> transporteList;
    @JoinColumn(name = "carreta_id_carreta", referencedColumnName = "id_carreta")
    @ManyToOne(optional = false)
    private Carreta carretaIdCarreta;
    @JoinColumn(name = "cavalo_id_cavalo", referencedColumnName = "id_cavalo")
    @ManyToOne(optional = false)
    private Cavalo cavaloIdCavalo;
    @JoinColumn(name = "motorista_id_motorista", referencedColumnName = "id_motorista")
    @ManyToOne(optional = false)
    private Motorista motoristaIdMotorista;

    public Caminhao() {
    }

    public Caminhao(Integer idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public Integer getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Integer idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public List<Transporte> getTransporteList() {
        return transporteList;
    }

    public void setTransporteList(List<Transporte> transporteList) {
        this.transporteList = transporteList;
    }

    public Carreta getCarretaIdCarreta() {
        return carretaIdCarreta;
    }

    public void setCarretaIdCarreta(Carreta carretaIdCarreta) {
        this.carretaIdCarreta = carretaIdCarreta;
    }

    public Cavalo getCavaloIdCavalo() {
        return cavaloIdCavalo;
    }

    public void setCavaloIdCavalo(Cavalo cavaloIdCavalo) {
        this.cavaloIdCavalo = cavaloIdCavalo;
    }

    public Motorista getMotoristaIdMotorista() {
        return motoristaIdMotorista;
    }

    public void setMotoristaIdMotorista(Motorista motoristaIdMotorista) {
        this.motoristaIdMotorista = motoristaIdMotorista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaminhao != null ? idCaminhao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caminhao)) {
            return false;
        }
        Caminhao other = (Caminhao) object;
        if ((this.idCaminhao == null && other.idCaminhao != null) || (this.idCaminhao != null && !this.idCaminhao.equals(other.idCaminhao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Caminhao[ idCaminhao=" + idCaminhao + " ]";
    }
    
}
