package com.ust.FavoriteService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.FavoriteService.model.Favorite;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Integer>{

	public Favorite findByUsername(String uname);

//	public Optional<Favorite> findById(String favId);

//	public void deleteById(String favId);
}
