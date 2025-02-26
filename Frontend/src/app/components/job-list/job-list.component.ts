import { Component, OnInit } from '@angular/core';
import { AnnonceService } from 'src/app/services/annonce.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css']
})
export class JobListComponent implements OnInit {
  jobs: any[] = [];
  filteredJobs: any[] = [];
  isMenuOpen = false; // Gestion du menu mobile

  constructor(private annonceService: AnnonceService, private router: Router) {}

  ngOnInit(): void {
    this.annonceService.getAnnonces().subscribe(
      (annonces: any) => {
        this.jobs = annonces;
        this.filteredJobs = [...this.jobs];
      },
      (error: any) => {
        console.error('Erreur lors du chargement des annonces :', error);
      }
    );
  }

  applyFilters(filters: any) {
    this.filteredJobs = this.jobs.filter((job) => {
      return (
        (!filters.searchTerm ||
          job.titre.toLowerCase().includes(filters.searchTerm.toLowerCase()) ||
          job.description.toLowerCase().includes(filters.searchTerm.toLowerCase()) ||
          job.recruteurUsername.toLowerCase().includes(filters.searchTerm.toLowerCase())) &&
        (!filters.category || job.type.toLowerCase().includes(filters.category.toLowerCase())) &&
        (!filters.datePublication ||
          new Date(job.datePublication).getTime() >= new Date(filters.datePublication).getTime())
      );
    });
  }

  apply(jobId: number) {
    alert(`Vous avez postulé à l'offre d'emploi #${jobId} !`);
  }

  // Gestion du menu mobile
  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }

  logout(): void {
    localStorage.removeItem('jwtToken');
    this.router.navigate(['/login']);
  }
}
