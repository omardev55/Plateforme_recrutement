import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminJobListComponent } from './admin-job-list.component';

describe('AdminJobListComponent', () => {
  let component: AdminJobListComponent;
  let fixture: ComponentFixture<AdminJobListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminJobListComponent]
    });
    fixture = TestBed.createComponent(AdminJobListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
