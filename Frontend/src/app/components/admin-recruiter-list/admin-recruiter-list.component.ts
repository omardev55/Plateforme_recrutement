import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-recruiter-list',
  templateUrl: './admin-recruiter-list.component.html',
  styleUrls: ['./admin-recruiter-list.component.css']
})
export class AdminRecruiterListComponent {
  recruiters = [
    { id: 1, name: 'Entreprise A', email: 'contact@entreprisea.com', registeredAt: '2024-12-01', status: '✅ Actif' },
    { id: 2, name: 'Entreprise B', email: 'info@entrepriseb.com', registeredAt: '2025-01-15', status: '⚠️ En attente' },
    { id: 3, name: 'Entreprise C', email: 'hr@entreprisec.com', registeredAt: '2025-02-01', status: '❌ Suspendu' }
  ];

  filters = {
    name: '',
    status: ''
  };

  filteredRecruiters = [...this.recruiters];

  applyFilters() {
    this.filteredRecruiters = this.recruiters.filter(recruiter => 
      (this.filters.name ? recruiter.name.toLowerCase().includes(this.filters.name.toLowerCase()) : true) &&
      (this.filters.status ? recruiter.status === this.filters.status : true)
    );
  }

  deleteRecruiter(id: number) {
    this.recruiters = this.recruiters.filter(recruiter => recruiter.id !== id);
    this.applyFilters();
  }
}
