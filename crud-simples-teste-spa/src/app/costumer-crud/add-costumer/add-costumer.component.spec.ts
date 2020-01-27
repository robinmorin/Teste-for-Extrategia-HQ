import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCostumerComponent } from './add-costumer.component';

describe('AddCostumerComponent', () => {
  let component: AddCostumerComponent;
  let fixture: ComponentFixture<AddCostumerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCostumerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCostumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
