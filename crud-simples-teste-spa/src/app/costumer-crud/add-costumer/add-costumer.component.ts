import { Component, OnInit, Output, Input } from '@angular/core';
import { Router } from '@angular/router';
import { CostumerServiceService } from 'src/app/services/costumer-service.service';
import { Costumer } from 'src/app/model/Costumer';


@Component({
  selector: 'app-add-costumer',
  templateUrl: './add-costumer.component.html',
  styleUrls: ['./add-costumer.component.css']
})
export class AddCostumerComponent implements OnInit {

  @Output() today:Date;

  @Input() costumer:Costumer=new Costumer();

  constructor(private _router:Router, private _service:CostumerServiceService) { }

  ngOnInit() {
  }

  addCostumer(costumer:Costumer){
    this._service.saveCostumer(this.costumer).subscribe(data=>{
      alert("Costumer is added successfully.");
      this._router.navigate(["list-all-costumers"]);
    });
  }

  backList(){
    this._router.navigate(["list-all-costumers"]);
  }

}
