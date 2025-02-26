import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-recruiter-job-create',
  templateUrl: './recruiter-job-create.component.html',
  styleUrls: ['./recruiter-job-create.component.css']
})
export class RecruiterJobCreateComponent {
  jobForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.jobForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      company: ['', Validators.required],
      location: ['', Validators.required],
      category: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  // Méthode pour soumettre le formulaire
  onSubmit(): void {
    if (this.jobForm.valid) {
      const newJob = this.jobForm.value;
      console.log('Nouvelle offre créée :', newJob);
      alert('Offre créée avec succès !');
      this.jobForm.reset(); // Réinitialise le formulaire après soumission
    } else {
      alert('Veuillez remplir tous les champs obligatoires.');
    }
  }
}