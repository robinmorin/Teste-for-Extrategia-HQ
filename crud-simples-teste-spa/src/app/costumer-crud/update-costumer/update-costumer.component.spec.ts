import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCostumerComponent } from './update-costumer.component';

describe('UpdateCostumerComponent', () => {
  let component: UpdateCostumerComponent;
  let fixture: ComponentFixture<UpdateCostumerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCostumerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCostumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
