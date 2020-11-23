package com.eufiscalizo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Infracao {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataInclusao;

    private String placa;

    private String tipoInfracao;

    private String descricao;

    private String latitude;

    private String longitude;

    private String renavam;

    @Enumerated(EnumType.STRING)
    private EnumSituacao situacao;


    @Column(columnDefinition = "text")
    private String caminhoArquivo;

    private Long usuarioInclusaoId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoInfracao() {
        return tipoInfracao;
    }

    public void setTipoInfracao(String tipoInfracao) {
        this.tipoInfracao = tipoInfracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String logitude) {
        this.longitude = logitude;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public Long getUsuarioInclusaoId() {
        return usuarioInclusaoId;
    }

    public void setUsuarioInclusaoId(Long usuarioInclusaoId) {
        this.usuarioInclusaoId = usuarioInclusaoId;
    }

    public EnumSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacao situacao) {
        this.situacao = situacao;
    }
}
