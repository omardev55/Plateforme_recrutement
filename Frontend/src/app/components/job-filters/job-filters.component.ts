import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-job-filters',
  templateUrl: './job-filters.component.html',
  styleUrls: ['./job-filters.component.css']
})
export class JobFiltersComponent {
  @Output() filtersChanged = new EventEmitter<any>();

  searchTerm: string = '';
  selectedCategory: string = '';
  selectedLocation: string = '';
  selectedSalary: string = '';

  categories = ['Développement', 'Design', 'Marketing', 'Data Science', 'DevOps'];
  locations = ['Casablanca', 'Tanger', 'Rabat', 'Marrakech'];
  salaries = ['20,000', '30,000', '40,000', '50,000'];

  // Appliquer les filtres et les envoyer au composant parent
  applyFilters() {
    this.filtersChanged.emit({
      searchTerm: this.searchTerm,
      category: this.selectedCategory,
      location: this.selectedLocation,
      salary: this.selectedSalary
    });
  }
}
