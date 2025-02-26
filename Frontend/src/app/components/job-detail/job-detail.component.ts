import { Component } from '@angular/core';

@Component({
  selector: 'app-job-detail',
  templateUrl: './job-detail.component.html',
  styleUrls: ['./job-detail.component.css']
})
export class JobDetailComponent {
  job = {
    id: 1,
    title: 'Développeur Angular',
    company: 'TechCorp',
    location: 'Paris',
    category: 'Développement',
    description: 'Recherche un développeur Angular expérimenté.',
    benefits: 'Une opportunité de travailler dans une entreprise innovante avec des collègues talentueux.'
  };

  applyToJob(): void {
    alert('Vous avez postulé avec succès à cette offre !');
  }
}