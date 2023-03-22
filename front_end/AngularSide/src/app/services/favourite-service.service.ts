import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favourite } from '../Favourite';

@Injectable({
  providedIn: 'root'
})
export class FavouriteServiceService {

  constructor(private httpClient: HttpClient) { }

  sendFav(fav: Favourite):Observable<any>
  {
    return this.httpClient.post<Array<any>>("http://localhost:8088/addFavorite",fav);
  }
  getFavourites():Observable<any>{
    return this.httpClient.get<Array<any>>('http://localhost:8088/viewFavorite/{username}')
  }
  deleteFavourites():Observable<any>{
    return this.httpClient.get<Array<any>>('http://localhost:8088/deleteById/{favId}')
  }
}
