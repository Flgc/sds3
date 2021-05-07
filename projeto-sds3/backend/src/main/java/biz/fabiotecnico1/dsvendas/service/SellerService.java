package biz.fabiotecnico1.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.fabiotecnico1.dsvendas.dto.SellerDTO;
import biz.fabiotecnico1.dsvendas.entities.Seller;
import biz.fabiotecnico1.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
