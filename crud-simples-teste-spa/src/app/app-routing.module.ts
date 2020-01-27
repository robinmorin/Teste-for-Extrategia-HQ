import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAllCostumersComponent } from './costumer-crud/list-all-costumers/list-all-costumers.component';
import { AddCostumerComponent } from './costumer-crud/add-costumer/add-costumer.component';
import { UpdateCostumerComponent } from './costumer-crud/update-costumer/update-costumer.component';


const routes: Routes = [
  { path: 'list-all-costumers', component: ListAllCostumersComponent },
  { path: 'add-costumer', component: AddCostumerComponent },
  { path: 'update-costumer', component: UpdateCostumerComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
