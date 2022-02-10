package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Supermarket;

public interface SupermarketService {
	public List<Supermarket> findAllSupermarket();

	public List<Supermarket> findAllActiveSupermarkets();

	public List<Supermarket> findAllNotActiveSupermarkets();

	public Supermarket findSupermarketById(long theId);

	public void saveSupermarket(Supermarket Supermarket);

	public void updateSupermarket(Supermarket Supermarket);

	public void deleteById(long theId);

}
