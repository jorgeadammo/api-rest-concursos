package com.jorgeadammo.sistemas.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgeadammo.sistemas.entity.Concurso;

public interface ConcursoRepository extends JpaRepository<Concurso, Long> {
}
