import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruteurDashboardComponent } from './recruteur-dashboard.component';

describe('RecruteurDashboardComponent', () => {
  let component: RecruteurDashboardComponent;
  let fixture: ComponentFixture<RecruteurDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecruteurDashboardComponent]
    });
    fixture = TestBed.createComponent(RecruteurDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
