import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-job-list',
  templateUrl: './admin-job-list.component.html',
  styleUrls: ['./admin-job-list.component.css']
})
export class AdminJobListComponent {
  jobs = [
    { id: 1, title: 'Développeur Angular', company: 'Tech Corp', postedDate: '2025-02-10', status: 'active' },
    { id: 2, title: 'Analyste Data', company: 'Data Solutions', postedDate: '2025-01-25', status: 'closed' },
    { id: 3, title: 'Designer UI/UX', company: 'Creative Hub', postedDate: '2025-02-05', status: 'active' }
  ];
  
  filteredJobs = [...this.jobs];

  filters = {
    title: '',
    company: '',
    startDate: '',
    endDate: '',
    status: ''
  };

  deleteModalVisible = false;
  selectedJobId!: number;

  applyFilters() {
    this.filteredJobs = this.jobs.filter(job => {
      return (
        (!this.filters.title || job.title.toLowerCase().includes(this.filters.title.toLowerCase())) &&
        (!this.filters.company || job.company.toLowerCase().includes(this.filters.company.toLowerCase())) &&
        (!this.filters.startDate || new Date(job.postedDate) >= new Date(this.filters.startDate)) &&
        (!this.filters.endDate || new Date(job.postedDate) <= new Date(this.filters.endDate)) &&
        (!this.filters.status || job.status === this.filters.status)
      );
    });
  }

  viewJob(id: number) {
    alert(`Affichage de l'annonce ID: ${id}`);
  }

  editJob(id: number) {
    alert(`Modification de l'annonce ID: ${id}`);
  }

  openDeleteModal(id: number) {
    this.selectedJobId = id;
    this.deleteModalVisible = true;
  }

  handleDeletion(id: number) {
    if (id !== -1) {
      this.jobs = this.jobs.filter(job => job.id !== id);
      this.applyFilters();
    }
    this.deleteModalVisible = false;
  }
  closeMenu(){

  }
  isMenuOpen(){

  }
  toggleMenu(){
    
  }
}
