import { Component } from '@angular/core';
import { Favourite } from 'src/app/Favourite';
import { CountryApiDetailsService } from 'src/app/services/country-api-details.service';
import {FavouriteServiceService} from 'src/app/services/favourite-service.service'

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  favourite: Favourite= new Favourite();
  countries:any;
  constructor(private service:CountryApiDetailsService,private favServ:FavouriteServiceService ) {}
  
  ngOnInit() {
    this.service.getCountries()
    .subscribe(response => {
      this.countries = response;
    });
  }

  addFavorite(item:any)
  {

   
      this.favourite.username="ananthu"
      this.favourite.capital=item.capital
      this.favourite.countryName=item.name.commo
      this.favourite.region=item.region
      this.favourite.subregion=item.subregion
      this.favourite.flag=item.flag;
      this.favourite.population=item.population;

    
    this.favServ.sendFav(this.favourite).subscribe((data: any) => console.log(data))
  }
}
