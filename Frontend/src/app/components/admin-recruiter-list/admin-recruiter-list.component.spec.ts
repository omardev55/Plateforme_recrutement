import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRecruiterListComponent } from './admin-recruiter-list.component';

describe('AdminRecruiterListComponent', () => {
  let component: AdminRecruiterListComponent;
  let fixture: ComponentFixture<AdminRecruiterListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminRecruiterListComponent]
    });
    fixture = TestBed.createComponent(AdminRecruiterListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
