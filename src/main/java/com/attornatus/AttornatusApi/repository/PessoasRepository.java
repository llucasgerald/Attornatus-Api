package com.attornatus.AttornatusApi.repository;

import com.attornatus.AttornatusApi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoasRepository extends JpaRepository<Pessoa,Long>{



}