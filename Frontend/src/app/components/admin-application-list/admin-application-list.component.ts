import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-application-list',
  templateUrl: './admin-application-list.component.html',
  styleUrls: ['./admin-application-list.component.css']
})
export class AdminApplicationListComponent implements OnInit {
  applications = [
    { id: 1, name: 'Omar El Mansouri', jobTitle: 'Développeur Full Stack', date: '2025-02-01', status: 'En attente', experience: 3 },
    { id: 2, name: 'Sarah Bennani', jobTitle: 'Designer UX/UI', date: '2025-01-29', status: 'Entretien prévu', experience: 2 },
  ];

  filteredApplications = [...this.applications];

  filters = {
    jobTitle: '',
    startDate: '',
    endDate: '',
    status: '',
    experience: ''
  };

  constructor() {}

  ngOnInit(): void {}

  applyFilters() {
    this.filteredApplications = this.applications.filter(app => {
      return (
        (this.filters.jobTitle ? app.jobTitle.toLowerCase().includes(this.filters.jobTitle.toLowerCase()) : true) &&
        (this.filters.startDate ? new Date(app.date) >= new Date(this.filters.startDate) : true) &&
        (this.filters.endDate ? new Date(app.date) <= new Date(this.filters.endDate) : true) &&
        (this.filters.status ? app.status === this.filters.status : true) &&
        (this.filters.experience ? app.experience >= parseInt(this.filters.experience) : true)
      );
    });
  }

  deleteApplication(id: number) {
    this.applications = this.applications.filter(app => app.id !== id);
    this.applyFilters();
  }

  changeStatus(application: any, newStatus: string) {
    application.status = newStatus;
  }
}
