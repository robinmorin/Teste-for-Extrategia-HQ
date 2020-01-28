import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Costumer } from '../model/Costumer';

@Injectable({
  providedIn: 'root'
})
export class CostumerServiceService{


  constructor(private _http:HttpClient) { }

  urlApi = "http://localhost:8099/crud-simples-costumer/costumers";

  getCostumers(){
    return this._http.get<Costumer[]>(this.urlApi+"/list");
  }

  saveCostumer(costumer:Costumer){
    return this._http.post<Costumer>(this.urlApi+"/add",costumer);
  }

  updateCostumer(costumer:Costumer){
    return this._http.put<Costumer>(this.urlApi+"/update",costumer);
  }

  getCostumer(idx:Number){
    return this._http.get<Costumer>(this.urlApi+ "/"+idx+"/costumer");
  }

  deleteCostumer(costumer:Costumer){
    return this._http.delete<Costumer>(this.urlApi+ "/delete/"+costumer.costumerid.toString());
  }

}
