import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recruiter-job-candidates',
  templateUrl: './recruiter-job-candidates.component.html',
  styleUrls: ['./recruiter-job-candidates.component.css']
})
export class RecruiterJobCandidatesComponent implements OnInit {
  candidates = [
    { id: 1, name: 'Omar El Mansouri', jobTitle: 'Développeur Full Stack', applicationDate: '2025-02-01', status: 'En attente', experience: 3, cvUrl: 'cv-omar.pdf' },
    { id: 2, name: 'Sarah Bennani', jobTitle: 'Designer UX/UI', applicationDate: '2025-01-29', status: 'Entretien prévu', experience: 2, cvUrl: 'cv-sarah.pdf' },
    { id: 3, name: 'Ali Rachid', jobTitle: 'Data Scientist', applicationDate: '2025-02-02', status: 'Accepté', experience: 5, cvUrl: 'cv-ali.pdf' },
    { id: 4, name: 'Mehdi Boulahcen', jobTitle: 'DevOps Engineer', applicationDate: '2025-01-30', status: 'Rejeté', experience: 4, cvUrl: 'cv-mehdi.pdf' },
    { id: 5, name: 'Hanae Lahlou', jobTitle: 'Spécialiste Marketing Digital', applicationDate: '2025-01-31', status: 'En attente', experience: 1, cvUrl: 'cv-hanae.pdf' }
  ];

  filteredCandidates = [...this.candidates];

  filters = {
    jobTitle: '',
    startDate: '',
    endDate: '',
    status: '',
    experience: ''
  };

  constructor(private router: Router) {}
  logout(): void {
    // Supprimer le token JWT du localStorage
    localStorage.removeItem('jwtToken');
    // Rediriger vers la page de connexion
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {}

  applyFilters() {
    this.filteredCandidates = this.candidates.filter(candidate => {
      return (
        (this.filters.jobTitle ? candidate.jobTitle.toLowerCase().includes(this.filters.jobTitle.toLowerCase()) : true) &&
        (this.filters.startDate ? new Date(candidate.applicationDate) >= new Date(this.filters.startDate) : true) &&
        (this.filters.endDate ? new Date(candidate.applicationDate) <= new Date(this.filters.endDate) : true) &&
        (this.filters.status ? candidate.status === this.filters.status : true) &&
        (this.filters.experience ? candidate.experience >= parseInt(this.filters.experience) : true)
      );
    });
  }

  changeStatus(candidate: any, newStatus: string) {
    candidate.status = newStatus;
  }

  viewCV(cvUrl: string) {
    window.open(cvUrl, '_blank');
  }
  isMenuOpen = false;

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }
}
