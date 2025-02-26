import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-candidate-profile',
  templateUrl: './edit-candidate-profile.component.html',
  styleUrls: ['./edit-candidate-profile.component.css']
})
export class EditCandidateProfileComponent {
  candidate = {
    name: "Omar A.",
    email: "omar@example.com",
    phone: "+212 600 000 000",
    experience: "3 ans",
    skills: "Angular, Spring Boot, Machine Learning",
    cv: null as File | null
  };

  constructor(private router: Router) {}

  saveProfile() {
    alert("Profil mis à jour !");
    this.router.navigate(['candidateprofile']); // Redirection vers le profil après sauvegarde
  }
  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.candidate.cv = input.files[0];
    }
  }
  viewdocs() {
    this.router.navigate(['/candidatedocuments']); // Redirection vers le profil après sauvegarde
  }
}
