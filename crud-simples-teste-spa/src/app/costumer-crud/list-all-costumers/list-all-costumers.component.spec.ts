import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllCostumersComponent } from './list-all-costumers.component';

describe('ListAllCostumersComponent', () => {
  let component: ListAllCostumersComponent;
  let fixture: ComponentFixture<ListAllCostumersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAllCostumersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllCostumersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
