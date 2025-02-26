import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobFiltersComponent } from './job-filters.component';

describe('JobFiltersComponent', () => {
  let component: JobFiltersComponent;
  let fixture: ComponentFixture<JobFiltersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JobFiltersComponent]
    });
    fixture = TestBed.createComponent(JobFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
