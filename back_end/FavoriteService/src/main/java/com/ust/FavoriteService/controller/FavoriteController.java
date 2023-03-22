package com.ust.FavoriteService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.FavoriteService.exception.FavoriteAlreadyExistException;
import com.ust.FavoriteService.model.Favorite;
import com.ust.FavoriteService.service.FavoriteServ;

@CrossOrigin
@RestController
public class FavoriteController {

	@Autowired
	FavoriteServ favoriteServ;
	
	@PostMapping("/addFavorite")
	public ResponseEntity<?> addFavorite(@RequestBody Favorite fav){
		
		try {
			Favorite favorite=favoriteServ.addFavorite(fav);
			return new ResponseEntity<Favorite>(fav,HttpStatus.OK);
		}
		catch(FavoriteAlreadyExistException e) {
			return new ResponseEntity<String>("Employee Already Exist",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/viewAllFavorite/{username}")
	public ResponseEntity<?> showAllEmps(String username){
		List<Favorite> viewAllFavorite = favoriteServ.viewAllFavorite(username);
		return new ResponseEntity<List>(viewAllFavorite,HttpStatus.OK);
	}
	@DeleteMapping("/deleteById/{favId}")
	public ResponseEntity<?> deleteEmp(@RequestBody int favId){
		boolean flag = favoriteServ.deleteFav(favId);
		
		if(flag) {
			return new ResponseEntity<String>("Employee Deleted ",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Employee Doesn't Exist",HttpStatus.NOT_FOUND);
		}
	}
	
//	@GetMapping("/viewAllFavorite")
//	public ResponseEntity<?> showAllFav(){
//		
//	}
}
