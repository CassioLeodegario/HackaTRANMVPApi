package com.eufiscalizo.repositories;

import com.eufiscalizo.model.Infracao;
import com.eufiscalizo.model.InfracaoNoImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfracaoRepository extends JpaRepository<Infracao, Long> {

    @Query("SELECT obj FROM Infracao obj order by obj.id desc")
    List<InfracaoNoImage> findAllSimpleByQuery();
}
