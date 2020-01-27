import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListAllCostumersComponent } from './costumer-crud/list-all-costumers/list-all-costumers.component';
import { AddCostumerComponent } from './costumer-crud/add-costumer/add-costumer.component';
import { UpdateCostumerComponent } from './costumer-crud/update-costumer/update-costumer.component';
import { DeleteCostumerComponent } from './costumer-crud/delete-costumer/delete-costumer.component';
import { FormsModule } from '@angular/forms';
import { CostumerServiceService } from './services/costumer-service.service';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    ListAllCostumersComponent,
    AddCostumerComponent,
    UpdateCostumerComponent,
    DeleteCostumerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CostumerServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
