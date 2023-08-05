package com.jorgeadammo.sistemas.entity;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Listener de edicao e persistencia dos dados, com ele preenchemos os valores
 * default de nossas entidades
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 2.2.0, 02/03/2016
  */
public class PersistentEntityListener {

    /**
     * Listerner de pre-persistencia do dados
     * 
     * @param entity a entidade a ser afetada pelo evento
     */
    @PrePersist
    public void prePersist(PersistentEntity entity) {
        entity.setInclusion(new Date());
        entity.setLastEdition(null);
    }
    
    /**
     * Listerner de pre-atualizacao do dados
     * 
     * @param entity a entidade a ser afetada pelo evento
     */
    @PreUpdate
    public void preUpdate(PersistentEntity entity) {
        entity.setLastEdition(new Date());
    }
   
}
