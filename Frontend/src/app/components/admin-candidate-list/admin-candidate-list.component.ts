import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-candidate-list',
  templateUrl: './admin-candidate-list.component.html',
  styleUrls: ['./admin-candidate-list.component.css']
})
export class AdminCandidateListComponent implements OnInit {
  candidates = [
    { id: 1, name: 'Omar El Mansouri', date: '2024-11-01', experience: 3, email: 'omar@example.com' },
    { id: 2, name: 'Sarah Bennani', date: '2024-10-21', experience: 2, email: 'sarah@example.com' }
  ];

  filteredCandidates = [...this.candidates];
  filters = { name: '', startDate: '', endDate: '', experience: '' };

  constructor() {}

  ngOnInit(): void {}

  applyFilters() {
    this.filteredCandidates = this.candidates.filter(candidate => 
      (this.filters.name ? candidate.name.toLowerCase().includes(this.filters.name.toLowerCase()) : true) &&
      (this.filters.startDate ? new Date(candidate.date) >= new Date(this.filters.startDate) : true) &&
      (this.filters.endDate ? new Date(candidate.date) <= new Date(this.filters.endDate) : true) &&
      (this.filters.experience ? candidate.experience >= parseInt(this.filters.experience) : true)
    );
  }

  deleteCandidate(id: number) {
    this.candidates = this.candidates.filter(candidate => candidate.id !== id);
    this.applyFilters();
  }

  viewCV(email: string) {
    window.open(`mailto:${email}`, '_blank');
  }
}
