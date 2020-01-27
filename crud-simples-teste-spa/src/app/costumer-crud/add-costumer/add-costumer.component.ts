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

today:Date = new Date();

  @Input() costumer:Costumer=new Costumer();

  constructor(private _router:Router, private _service:CostumerServiceService) { }

  ngOnInit() {
  }

  addCostumer(){
    this.costumer.costumerid = 0;
    this.costumer.create_at = this.today;
    this._service.saveCostumer(this.costumer).subscribe(data=>{
      alert("Costumer is added successfully.");
      this._router.navigate(["list-all-costumers"]);
    });
  }

  backList(){
    this._router.navigate(["list-all-costumers"]);
  }

}
