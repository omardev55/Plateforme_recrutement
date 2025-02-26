import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruiterJobDeleteComponent } from './recruiter-job-delete.component';

describe('RecruiterJobDeleteComponent', () => {
  let component: RecruiterJobDeleteComponent;
  let fixture: ComponentFixture<RecruiterJobDeleteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecruiterJobDeleteComponent]
    });
    fixture = TestBed.createComponent(RecruiterJobDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
