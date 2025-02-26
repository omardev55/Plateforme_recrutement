import { TestBed } from '@angular/core/testing';
import { JobService } from './job.service';
import { MOCK_JOBS } from './mock-jobs'; // Importe les données mock

describe('JobService', () => {
  let service: JobService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all jobs', () => {
    service.getJobs().subscribe(jobs => {
      expect(jobs.length).toBeGreaterThan(0); // Vérifie qu'il y a des offres d'emploi
    });
  });

  it('should return a specific job by ID', () => {
    const jobId = 1;
    service.getJobById(jobId).subscribe(job => {
      expect(job.id).toBe(jobId); // Vérifie que l'ID correspond
    });
  });

  it('should add a new job', () => {
    const newJob = { id: 5, title: 'Nouvelle Offre', company: 'TestCo' };
    service.addJob(newJob).subscribe(result => {
      expect(result).toEqual(newJob); // Vérifie que l'offre a été ajoutée
    });
  });

  it('should update an existing job', () => {
    const updatedJob = { id: 1, title: 'Offre Modifiée', company: 'TechCorp' };
    service.updateJob(1, updatedJob).subscribe(result => {
      expect(result).toEqual(updatedJob); // Vérifie que l'offre a été mise à jour
    });
  });

  it('should delete a job', () => {
    service.deleteJob(1).subscribe(result => {
      expect(result.success).toBe(true); // Vérifie que la suppression a réussi
    });
  });
});