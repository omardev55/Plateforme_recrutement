import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recruiter-job-list',
  templateUrl: './recruiter-job-list.component.html',
  styleUrls: ['./recruiter-job-list.component.css']
})
export class RecruiterJobListComponent implements OnInit {
  jobs = [
    { id: 1, title: 'Développeur Angular', company: 'TechCorp', location: 'Paris', category: 'Développement' },
    { id: 2, title: 'Designer/dev UI/UX', company: 'DesignLab', location: 'Lyon', category: 'Design' },
    { id: 3, title: 'Designer/data UI/UX', company: 'DesignLab', location: 'Lyon', category: 'Design' },
    { id: 4, title: 'Designer/cc  UI/UX', company: 'DesignLab', location: 'Lyon', category: 'Design' },
  ];

  constructor(private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Vérifie si une offre a été supprimée
    this.route.queryParams.subscribe(params => {
      const deletedId = params['deleted'];
      if (deletedId) {
        this.jobs = this.jobs.filter(job => job.id !== +deletedId);
        alert('Offre supprimée avec succès.');
      }
    });
  }

  // Méthode pour éditer une offre
  editJob(id: number): void {
    console.log('Redirection vers l\'édition de l\'offre (ID :', id, ')');
    this.router.navigate(['/recruiter/job-edit', id]);
  }
}