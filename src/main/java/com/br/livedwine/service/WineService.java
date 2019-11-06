package com.br.livedwine.service;

import com.br.livedwine.model.Wine;
import com.br.livedwine.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Lucas Copque
 * @version 1.0
 * @since 06/11/2019
 */
@Service
public class WineService {

    private WineRepository repository;

    @Autowired
    public WineService(WineRepository repository){
        this.repository = repository;
    }

    public Optional<Wine> finById(Long id){
        return repository.findById(id);
    }

    public Optional<Wine> findByNameLike(String name){
        return repository.findByNameLike("%" + name + "%");
    }

    public Page<Wine> listAll(Pageable pageable){
        return repository.findAll(pageable);
    }
}
