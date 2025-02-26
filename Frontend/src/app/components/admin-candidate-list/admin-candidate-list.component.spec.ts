import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCandidateListComponent } from './admin-candidate-list.component';

describe('AdminCandidateListComponent', () => {
  let component: AdminCandidateListComponent;
  let fixture: ComponentFixture<AdminCandidateListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminCandidateListComponent]
    });
    fixture = TestBed.createComponent(AdminCandidateListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
