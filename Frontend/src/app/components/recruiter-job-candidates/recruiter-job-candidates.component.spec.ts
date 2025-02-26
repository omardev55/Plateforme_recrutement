import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruiterJobCandidatesComponent } from './recruiter-job-candidates.component';

describe('RecruiterJobCandidatesComponent', () => {
  let component: RecruiterJobCandidatesComponent;
  let fixture: ComponentFixture<RecruiterJobCandidatesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecruiterJobCandidatesComponent]
    });
    fixture = TestBed.createComponent(RecruiterJobCandidatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
