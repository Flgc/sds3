package biz.fabiotecnico1.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.fabiotecnico1.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
