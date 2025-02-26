import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recruiter-job-delete',
  templateUrl: './recruiter-job-delete.component.html',
  styleUrls: ['./recruiter-job-delete.component.css']
})
export class RecruiterJobDeleteComponent implements OnInit {
  jobId: number | null = null;

  constructor(private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Récupère l'ID de l'offre depuis les paramètres de l'URL
    const idParam = this.route.snapshot.paramMap.get('id'); // Peut être null
    if (idParam) {
      this.jobId = +idParam; // Convertit en nombre
    } else {
      this.jobId = null; // Si l'ID est manquant, définis explicitement à null
      alert('ID de l\'offre manquant.');
      this.router.navigate(['/recruiter/jobs']); // Redirige vers la liste des offres
    }

    if (!this.jobId) {
      console.error('ID de l\'offre invalide.');
    }
  }

  confirmDelete(): void {
    if (this.jobId) {
      console.log('Suppression confirmée pour l\'offre ID :', this.jobId);
      this.router.navigate(['/recruiter/jobs'], { queryParams: { deleted: this.jobId } });
    } else {
      console.error('Impossible de supprimer : ID de l\'offre manquant.');
    }
  }

  cancelDelete(): void {
    console.log('Suppression annulée.');
    this.router.navigate(['/recruiter/jobs']); // Retourne à la liste des offres
  }
}