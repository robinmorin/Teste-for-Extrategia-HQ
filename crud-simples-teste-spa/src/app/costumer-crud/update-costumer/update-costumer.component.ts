import { Component, OnInit } from '@angular/core';
import { CostumerServiceService } from 'src/app/services/costumer-service.service';
import { Router } from '@angular/router';
import { Costumer } from 'src/app/model/Costumer';

@Component({
  selector: 'app-update-costumer',
  templateUrl: './update-costumer.component.html',
  styleUrls: ['./update-costumer.component.css']
})
export class UpdateCostumerComponent implements OnInit {

  constructor(private _service:CostumerServiceService, private _router:Router) { }

  ngOnInit() {
    this.findConsumer(2);
  }

  findConsumer(idx:Number){
      return this._service.getCostumer(idx);
  }

  updateCostumer(costumer:Costumer){
    
  }

}
