package com.example.demo.RestControllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entities.Supermarket;
import com.example.demo.Reposatories.SupermarketReposatory;
import com.example.demo.Service.SupermarketService;

@RestController
@RequestMapping(value = "/Supermarkets")
public class SupermarketRestController {
	@Autowired
	SupermarketService SupermarketService;

	@Autowired
	SupermarketReposatory SupermarketReposatory;

	// upload photo for supermarket
	@PostMapping("/uploadimage/{itemCode}")
	public ResponseEntity<Supermarket> uploadProfilePic(@PathVariable(value = "itemCode") String itemCode,
			@RequestParam(value = "file", required = false) MultipartFile image) {

		if (image.isEmpty()) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		} else {
			try {
				byte[] byteObjects = new byte[image.getBytes().length];
				int i = 0;
				for (byte b : image.getBytes()) {
					byteObjects[i++] = b;
				}
				// create product photo
				Supermarket Supermarket = new Supermarket();
				Supermarket.setImage(byteObjects);
				SupermarketService.updateSupermarket(Supermarket);
				return new ResponseEntity(SupermarketReposatory.save(Supermarket), HttpStatus.OK);

			} catch (IOException e) {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

// update Supermarket data
	@PutMapping("/UpdateSupermarket")
	public ResponseEntity<Supermarket> UpdateSupermarket(@RequestBody Supermarket Supermarket) {
		try {
			return new ResponseEntity(SupermarketReposatory.save(Supermarket), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// add new Supermarket
	@PostMapping("/SaveSupermarket")
	public ResponseEntity<Supermarket> SaveSupermarket(@RequestBody Supermarket Supermarket) {
		try {

			if (Supermarket.getSupermarket_id() != null) {
				SupermarketService.updateSupermarket(Supermarket);
				return new ResponseEntity(HttpStatus.OK);

			} else {
				return new ResponseEntity(SupermarketReposatory.save(Supermarket), HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete Supermarket by id
	@DeleteMapping("/DeleteSupermarket/{id}")
	public ResponseEntity<HttpStatus> DeleteSupermarket(@PathVariable Long id) {
		try {
			if (id != null) {
				SupermarketService.deleteById(id);
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// list of all Supermarkets
	@GetMapping("/AllSupermarkets")
	public ResponseEntity<List<Supermarket>> AllSupermarkets() {
		try {
			List<Supermarket> AllSupermarkets = SupermarketService.findAllSupermarket();
			if (AllSupermarkets != null && AllSupermarkets.size() > 0) {
				return new ResponseEntity(AllSupermarkets, HttpStatus.OK);

			} else {
				return new ResponseEntity(AllSupermarkets, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// list of all Active Supermarkets
	@GetMapping("/AllActiveSupermarkets")
	public ResponseEntity<List<Supermarket>> AllActiveSupermarkets() {
		try {
			List<Supermarket> AllSupermarkets = SupermarketService.findAllActiveSupermarkets();
			if (AllSupermarkets != null && AllSupermarkets.size() > 0) {
				return new ResponseEntity(AllSupermarkets, HttpStatus.OK);

			} else {
				return new ResponseEntity(AllSupermarkets, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// list of all none Active Supermarkets
	@GetMapping("/AllNotActiveSupermarkets")
	public ResponseEntity<List<Supermarket>> AllNotActiveSupermarkets() {
		try {
			List<Supermarket> AllSupermarkets = SupermarketService.findAllNotActiveSupermarkets();
			if (AllSupermarkets != null && AllSupermarkets.size() > 0) {
				return new ResponseEntity(AllSupermarkets, HttpStatus.OK);

			} else {
				return new ResponseEntity(AllSupermarkets, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
