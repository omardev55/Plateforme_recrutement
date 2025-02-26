import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateDocumentsComponent } from './candidate-documents.component';

describe('CandidateDocumentsComponent', () => {
  let component: CandidateDocumentsComponent;
  let fixture: ComponentFixture<CandidateDocumentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CandidateDocumentsComponent]
    });
    fixture = TestBed.createComponent(CandidateDocumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
