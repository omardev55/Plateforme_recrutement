import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminApplicationListComponent } from './admin-application-list.component';

describe('AdminApplicationListComponent', () => {
  let component: AdminApplicationListComponent;
  let fixture: ComponentFixture<AdminApplicationListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminApplicationListComponent]
    });
    fixture = TestBed.createComponent(AdminApplicationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
