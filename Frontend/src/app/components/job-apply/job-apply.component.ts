import { Component } from '@angular/core';

@Component({
  selector: 'app-job-apply',
  templateUrl: './job-apply.component.html',
  styleUrls: ['./job-apply.component.css']
})
export class JobApplyComponent {
  application = {
    name: '',
    email: '',
    phone: '',
    coverLetter: ''
  };

  selectedFile: File | null = null;
  fileTouched = false;
  submitted = false;

  // Gestion de la sélection du fichier CV
  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file && file.type === 'application/pdf') {
      this.selectedFile = file;
      this.fileTouched = false;
    } else {
      this.selectedFile = null;
      this.fileTouched = true;
    }
  }

  // Soumission du formulaire
  submitApplication() {
    if (this.application.name && this.application.email && this.application.phone && this.selectedFile) {
      this.submitted = true;

      // Simuler un envoi de données (peut être remplacé par une requête API)
      console.log("Candidature envoyée :", this.application);
    }
  }
}
