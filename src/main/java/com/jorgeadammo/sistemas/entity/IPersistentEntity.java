package com.jorgeadammo.sistemas.entity;

import java.io.Serializable;

/**
 * Interface que define os metodos minimos que uma entidade deve possuir para
 * ser considerada uma entitdade valida na regra de negocios deste sistema
 *
 * @param <T> qualquer coisa que seja serializavel
 *
 */
public interface IPersistentEntity<T extends Serializable> {

    /**
     * Getter para o ID da entidade
     *
     * @return o id da entidade
     */
    public T getId();

    /**
     * Metodo que indica se uma entidade ja foi ou nao persistida (salva)
     *
     * @return se a entidade ja foi persistida, retorna <code>true</code>
     * indicando
     * que a mesma ja foi salva se nao retorna <code>false</code>
     */
    public boolean isSaved();
}
