package br.com.matheus.devdojo.springboot.repository;

import br.com.matheus.devdojo.springboot.domain.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessorRepository extends JpaRepository<Processor, Long> {

}
