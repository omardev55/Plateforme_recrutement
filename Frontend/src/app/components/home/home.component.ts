import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  // Données simulées (mock)
  jobs = [
    {
      id: 1,
      title: 'Développeur Angular',
      company: 'TechCorp',
      location: 'Paris',
      category: 'Développement',
      description: 'Recherche un développeur Angular expérimenté.'
    },
    {
      id: 2,
      title: 'Designer UI/UX',
      company: 'DesignLab',
      location: 'Lyon',
      category: 'Design',
      description: 'Créer des interfaces utilisateur modernes et intuitives.'
    },
    {
      id: 3,
      title: 'Ingénieur DevOps',
      company: 'CloudCo',
      location: 'Marseille',
      category: 'Infrastructure',
      description: 'Gérer les déploiements et automatiser les processus.'
    }
  ];

  // Filtrer les offres mises en avant
  highlightedJobs = this.jobs.slice(0, 2); // Prend les deux premières offres

  // Variables pour les filtres
  filteredJobs = this.jobs;
  searchTerm = '';
  categoryFilter = '';
  locationFilter = '';
  categories = ['Développement', 'Design', 'Infrastructure', 'Management'];

  // Recherche en temps réel
  onSearch(): void {
    this.applyFilters();
  }

  // Appliquer les filtres
  onFilter(): void {
    this.applyFilters();
  }

  applyFilters(): void {
    this.filteredJobs = this.jobs.filter(job =>
      job.title.toLowerCase().includes(this.searchTerm.toLowerCase()) &&
      (this.categoryFilter ? job.category === this.categoryFilter : true) &&
      (this.locationFilter ? job.location.includes(this.locationFilter) : true)
    );
  }
}