import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidate-profile',
  templateUrl: './candidate-profile.component.html',
  styleUrls: ['./candidate-profile.component.css']
})
export class CandidateProfileComponent {
  candidate = {
    name: "Omar A.",
    email: "omar@example.com",
    phone: "+212 600 000 000",
    experience: "3 ans",
    skills: ["Angular", "Spring Boot", "Machine Learning"],
    cv: "cv_omar.pdf"
  };

  constructor(private router: Router) {}

  editProfile() {
    this.router.navigate(['/editcandidateprofile']); // Redirection vers le composant de modification
  }
}
