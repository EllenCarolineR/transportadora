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
@Table(name = "motorista")
@NamedQueries({
    @NamedQuery(name = "Motorista.findAll", query = "SELECT m FROM Motorista m")})
public class Motorista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_motorista")
    private Integer idMotorista;
    @Basic(optional = false)
    @Column(name = "nome_motorista")
    private String nomeMotorista;
    @Basic(optional = false)
    @Column(name = "telefone_motorista")
    private String telefoneMotorista;
    @Basic(optional = false)
    @Column(name = "endereco_motorista")
    private String enderecoMotorista;
    @Basic(optional = false)
    @Column(name = "caminho")
    private String caminho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motoristaIdMotorista")
    private List<Transporte> transporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motoristaIdMotorista")
    private List<Caminhao> caminhaoList;

    public Motorista() {
    }

    public Motorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Motorista(Integer idMotorista, String nomeMotorista, String telefoneMotorista, String enderecoMotorista, String caminho) {
        this.idMotorista = idMotorista;
        this.nomeMotorista = nomeMotorista;
        this.telefoneMotorista = telefoneMotorista;
        this.enderecoMotorista = enderecoMotorista;
        this.caminho = caminho;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getTelefoneMotorista() {
        return telefoneMotorista;
    }

    public void setTelefoneMotorista(String telefoneMotorista) {
        this.telefoneMotorista = telefoneMotorista;
    }

    public String getEnderecoMotorista() {
        return enderecoMotorista;
    }

    public void setEnderecoMotorista(String enderecoMotorista) {
        this.enderecoMotorista = enderecoMotorista;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public List<Transporte> getTransporteList() {
        return transporteList;
    }

    public void setTransporteList(List<Transporte> transporteList) {
        this.transporteList = transporteList;
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
        hash += (idMotorista != null ? idMotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.idMotorista == null && other.idMotorista != null) || (this.idMotorista != null && !this.idMotorista.equals(other.idMotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Motorista[ idMotorista=" + idMotorista + " ]";
    }
    
}
