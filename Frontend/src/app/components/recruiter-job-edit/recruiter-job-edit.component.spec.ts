import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruiterJobEditComponent } from './recruiter-job-edit.component';

describe('RecruiterJobEditComponent', () => {
  let component: RecruiterJobEditComponent;
  let fixture: ComponentFixture<RecruiterJobEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecruiterJobEditComponent]
    });
    fixture = TestBed.createComponent(RecruiterJobEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
