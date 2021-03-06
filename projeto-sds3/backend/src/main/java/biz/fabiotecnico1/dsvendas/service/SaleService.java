package biz.fabiotecnico1.dsvendas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import biz.fabiotecnico1.dsvendas.dto.SaleDTO;
import biz.fabiotecnico1.dsvendas.dto.SaleSuccessDTO;
import biz.fabiotecnico1.dsvendas.dto.SaleSumDTO;
import biz.fabiotecnico1.dsvendas.entities.Sale;
import biz.fabiotecnico1.dsvendas.repositories.SaleRepository;
import biz.fabiotecnico1.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupeBySeller(){
		return repository.amountGroupeBySeller();		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupeBySeller(){
		return repository.successGroupeBySeller();		
	}
}

