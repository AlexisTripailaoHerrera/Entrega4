import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarEliminadosComponent } from './listar-eliminados.component';

describe('ListarEliminadosComponent', () => {
  let component: ListarEliminadosComponent;
  let fixture: ComponentFixture<ListarEliminadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListarEliminadosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarEliminadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
