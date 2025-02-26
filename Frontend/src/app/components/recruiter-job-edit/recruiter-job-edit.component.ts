import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recruiter-job-edit',
  templateUrl: './recruiter-job-edit.component.html',
  styleUrls: ['./recruiter-job-edit.component.css']
})
export class RecruiterJobEditComponent implements OnInit {
  jobForm!: FormGroup; // Correction : Ajoute le modificateur !
  jobId: number = -1; // Correction : Initialise avec une valeur par défaut

  // Données simulées pour les offres d'emploi
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
    }
  ];

  constructor(private fb: FormBuilder, private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Récupère l'ID de l'URL (avec correction)
    this.jobId = +(this.route.snapshot.paramMap.get('id') ?? -1);

    if (this.jobId > 0) {
      const job = this.jobs.find(j => j.id === this.jobId); // Trouve l'offre correspondante
      if (job) {
        this.initForm(job); // Initialise le formulaire avec les données de l'offre
      } else {
        alert('Offre non trouvée.');
      }
    } else {
      alert('ID de l\'offre manquant ou invalide.');
    }
  }

  // Initialise le formulaire avec les données de l'offre
  initForm(job: any): void {
    this.jobForm = this.fb.group({
      title: [job.title, [Validators.required, Validators.minLength(3)]],
      company: [job.company, Validators.required],
      location: [job.location, Validators.required],
      category: [job.category, Validators.required],
      description: [job.description, Validators.required]
    });
  }

  // Méthode pour soumettre le formulaire
  onSubmit(): void {
    if (this.jobForm.valid && this.jobId > 0) {
      const updatedJob = this.jobForm.value;
      updatedJob.id = this.jobId;

      console.log('Offre mise à jour :', updatedJob);
      alert('Offre mise à jour avec succès !');
    } else {
      alert('Veuillez remplir tous les champs obligatoires.');
    }
  }
}