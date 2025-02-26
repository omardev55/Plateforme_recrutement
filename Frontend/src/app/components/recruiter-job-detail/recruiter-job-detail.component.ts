import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recruiter-job-detail',
  templateUrl: './recruiter-job-detail.component.html',
  styleUrls: ['./recruiter-job-detail.component.css']
})
export class RecruiterJobDetailComponent {
  jobId: number;
  job = {
    id: 1,
    title: "Développeur Full Stack",
    description: "Nous recherchons un développeur Full Stack pour rejoindre notre équipe dynamique.",
    salary: "3000 - 5000€",
    location: "Paris, France",
    publishedAt: "2025-02-01",
    status: "Ouvert"
  };

  candidates = [
    { id: 1, name: "Omar A.", experience: "3 ans", email: "omar@example.com", status: "En attente" },
    { id: 2, name: "Sarah B.", experience: "5 ans", email: "sarah@example.com", status: "Accepté" },
    { id: 3, name: "Karim C.", experience: "2 ans", email: "karim@example.com", status: "Refusé" }
  ];

  constructor(private route: ActivatedRoute, private router: Router) {
    this.jobId = Number(this.route.snapshot.paramMap.get('id'));
  }

  editJob() {
    alert("Modifier l'annonce !");
  }

  deleteJob() {
    if (confirm("Voulez-vous vraiment supprimer cette annonce ?")) {
      alert("Annonce supprimée !");
      this.router.navigate(['/recruiter/jobs']); // Redirection après suppression
    }
  }

  viewCV(email: string) {
    alert("Voir le CV de " + email);
  }
}
