import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruiterJobCreateComponent } from './recruiter-job-create.component';

describe('RecruiterJobCreateComponent', () => {
  let component: RecruiterJobCreateComponent;
  let fixture: ComponentFixture<RecruiterJobCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecruiterJobCreateComponent]
    });
    fixture = TestBed.createComponent(RecruiterJobCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
