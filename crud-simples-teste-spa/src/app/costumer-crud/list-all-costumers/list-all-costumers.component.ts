import { Component, OnInit } from '@angular/core';
import { CostumerServiceService } from 'src/app/services/costumer-service.service';
import { Router } from '@angular/router';
import { Costumer } from 'src/app/model/Costumer';

@Component({
  selector: 'app-list-all-costumers',
  templateUrl: './list-all-costumers.component.html',
  styleUrls: ['./list-all-costumers.component.css']
})
export class ListAllCostumersComponent implements OnInit {

  costumers:Costumer[];

  constructor(private _service:CostumerServiceService, private _router:Router) { }

  ngOnInit() {

      this._service.getCostumers().subscribe(data=>
        {this.costumers =data});

  }

  getAddCostumer(){
    this._router.navigate(["add-costumer"]);
  }

  callConsumer(idx:Number){
    this._router.navigate(["update-costumer"]);
  }

}
