package com.eufiscalizo.model;

import java.util.Date;

public interface InfracaoNoImage {

    Long getId();
    Date getDataInclusao();
    String getPlaca();
    String getTipoInfracao();
    String getDescricao();
    String getLatitude();
    String getLongitude();
    String getRenavam();
    EnumSituacao getSituacao();
    Long getUsuarioInclusaoId();
}
