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

  costumer:Costumer=new Costumer();

  constructor(private _service:CostumerServiceService, private _router:Router) { }

  ngOnInit() {
      this.updateCostumer();
  }

  updateCostumer(){
    let id=localStorage.getItem("id");
    this._service.getCostumer(+id).subscribe(data=>{
      this.costumer = data;
    });
  }

  saveCostumer(){
    this._service.updateCostumer(this.costumer).subscribe(data=>{
      alert("Costumer is updated successfully.");
      this._router.navigate(["list-all-costumers"]);
    });
  }

  backList(){
    this._router.navigate(["list-all-costumers"]);
  }
  
}
