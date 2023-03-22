package com.ust.FavoriteService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.FavoriteService.exception.FavoriteAlreadyExistException;
import com.ust.FavoriteService.model.Favorite;
import com.ust.FavoriteService.repository.FavoriteRepo;

@Service
public class FavoriteServImpl implements FavoriteServ {

	@Autowired
	FavoriteRepo repo;
	
	@Override
	public Favorite addFavorite(Favorite fav) throws FavoriteAlreadyExistException {
		// TODO Auto-generated method stub
		Favorite empExist = findFavoriteById(fav.getFavoriteId());
		if(empExist!=null) {
			throw new FavoriteAlreadyExistException();
		}else {
			Favorite empSaved = repo.save(fav);
			return empSaved;
		}
	}

	@Override
	public Favorite findFavoriteById(int favId) {
		// TODO Auto-generated method stub
		Optional<Favorite> opt =repo.findById(favId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

 
	@Override
	public boolean deleteFav(int favId) {
		// TODO Auto-generated method stub
		Favorite fav = findFavoriteById(favId);
		if(fav!=null) {
			repo.deleteById(favId);
			return true;
		}
		return false;
	}

	@Override
	public List<Favorite> viewAllFavorite(String username) {
		// TODO Auto-generated method stub
		List<Favorite> allFav = repo.findAll();
		return allFav;
	}

}
