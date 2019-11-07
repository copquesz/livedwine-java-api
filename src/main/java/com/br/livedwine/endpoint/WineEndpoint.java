package com.br.livedwine.endpoint;

import com.br.livedwine.exception.ResourceNotFoundException;
import com.br.livedwine.model.Wine;
import com.br.livedwine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Lucas Copque
 * @version 1.0
 * @since 06/11/2019
 */
@RestController
@RequestMapping("v1/wines")
public class WineEndpoint {

    private WineService wineService;

    @Autowired
    public WineEndpoint(WineService wineService){
        this.wineService = wineService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Wine> getById(@PathVariable Long id){
        verifyIfWineExistsById(id);
        return new ResponseEntity<>(wineService.finById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Wine> getByName(@PathVariable String name){
        verifyIfWineExistsByName(name);
        return new ResponseEntity<>(wineService.findByNameLike(name).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Wine>> listAll(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(wineService.listAll(pageable), HttpStatus.OK);
    }


    private void verifyIfWineExistsById(Long id) {
        if (!wineService.finById(id).isPresent()) {
            throw new ResourceNotFoundException("Wine not found for ID: " + id);
        }
    }

    private void verifyIfWineExistsByName(String name) {
        if (!wineService.findByNameLike(name).isPresent()) {
            throw new ResourceNotFoundException("Wine not found for Name: " + name);
        }
    }
}
