/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ellen
 */
@Entity
@Table(name = "transporte")
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_transporte")
    private Integer idTransporte;
    @Basic(optional = false)
    @Column(name = "origem_destino")
    private String origemDestino;
    @Basic(optional = false)
    @Column(name = "fim_destino")
    private String fimDestino;
    @Basic(optional = false)
    @Column(name = "valor_frete")
    private double valorFrete;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "caminhao_id_caminhao", referencedColumnName = "id_caminhao")
    @ManyToOne(optional = false)
    private Caminhao caminhaoIdCaminhao;
    @JoinColumn(name = "motorista_id_motorista", referencedColumnName = "id_motorista")
    @ManyToOne(optional = false)
    private Motorista motoristaIdMotorista;

    public Transporte() {
    }

    public Transporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Transporte(Integer idTransporte, String origemDestino, String fimDestino, double valorFrete, Date data) {
        this.idTransporte = idTransporte;
        this.origemDestino = origemDestino;
        this.fimDestino = fimDestino;
        this.valorFrete = valorFrete;
        this.data = data;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getOrigemDestino() {
        return origemDestino;
    }

    public void setOrigemDestino(String origemDestino) {
        this.origemDestino = origemDestino;
    }

    public String getFimDestino() {
        return fimDestino;
    }

    public void setFimDestino(String fimDestino) {
        this.fimDestino = fimDestino;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Caminhao getCaminhaoIdCaminhao() {
        return caminhaoIdCaminhao;
    }

    public void setCaminhaoIdCaminhao(Caminhao caminhaoIdCaminhao) {
        this.caminhaoIdCaminhao = caminhaoIdCaminhao;
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
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
