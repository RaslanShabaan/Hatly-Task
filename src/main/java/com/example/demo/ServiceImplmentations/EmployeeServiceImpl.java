package com.example.demo.ServiceImplmentations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Supermarket;
import com.example.demo.Service.SupermarketService;

@Service
public class EmployeeServiceImpl implements SupermarketService {
	@Autowired
	com.example.demo.Reposatories.SupermarketReposatory EmployeeReposatory;

	public List<Supermarket> findAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findAll();
	}

	public Supermarket findSupermarketById(long theId) {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findById(theId).orElse(null);
	}

	public void saveSupermarket(Supermarket Employee) {
		// TODO Auto-generated method stub
		EmployeeReposatory.save(Employee);
	}

	public void updateSupermarket(Supermarket Employee) {
		// TODO Auto-generated method stub
		EmployeeReposatory.save(Employee);
	}

	public void deleteById(long theId) {
		// TODO Auto-generated method stub
		EmployeeReposatory.deleteById(theId);
	}

	public List<Supermarket> findAllSupermarket() {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findAll();
	}

	public List<Supermarket> findAllActiveSupermarkets() {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findAllActiveSupermarkets();
	}

	public List<Supermarket> findAllNotActiveSupermarkets() {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findAllNotActiveSupermarkets();
	}

}
