package com.ust.FavoriteService.service;

import java.util.List;

import com.ust.FavoriteService.exception.FavoriteAlreadyExistException;
import com.ust.FavoriteService.model.Favorite;


public interface FavoriteServ {

	Favorite addFavorite(Favorite fav)throws FavoriteAlreadyExistException;
	Favorite findFavoriteById(int favId);
	List<Favorite> viewAllFavorite(String username);
	boolean deleteFav(int favId);
	
}
