package com.ust.FavoriteService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int favoriteId;
	
	String username,countryName,capital,flag,region,subregion,population;
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favorite(int favoriteId, String username, String countryName, String capital, 
			String flag, String region, String subregion,  String population) {
		super();
		this.favoriteId = favoriteId;
		this.username = username;
		this.countryName = countryName;
		this.capital = capital;
		this.flag = flag;
		this.region = region;
		this.subregion = subregion;
		this.population = population;
	}
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
}
