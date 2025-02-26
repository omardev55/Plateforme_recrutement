import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AnnonceService } from '../../services/annonce.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recruteur-dashboard',
  templateUrl: './recruteur-dashboard.component.html',
  styleUrls: ['./recruteur-dashboard.component.css']
})
export class RecruteurDashboardComponent {
  annonceForm: FormGroup;
  successMessage: string = '';

  constructor(private fb: FormBuilder, private annonceService: AnnonceService, private router: Router) {
    this.annonceForm = this.fb.group({
      titre: ['', [Validators.required]],
      description: ['', [Validators.required]],
      type: ['CDI', [Validators.required]] // 🔹 Par défaut, CDI sélectionné
    });
  }
  logout(): void {
    // Supprimer le token JWT du localStorage
    localStorage.removeItem('jwtToken');
    // Rediriger vers la page de connexion
    this.router.navigate(['/login']);
  }

  onSubmit(): void {
    if (this.annonceForm.valid) {
        console.log('Données envoyées au backend :', this.annonceForm.value); // Log pour déboguer
        this.annonceService.ajouterAnnonce(this.annonceForm.value).subscribe({
            next: (response) => {
                console.log('✅ Annonce publiée avec succès', response);
                this.successMessage = 'Annonce publiée avec succès !';
                this.annonceForm.reset();
            },
            error: (error) => {
                console.error('❌ Erreur lors de la publication', error);
                this.successMessage = 'Une erreur est survenue. Veuillez réessayer.';
            }
        });
    } else {
        console.log('❌ Formulaire invalide');
    }
}
isMenuOpen = false;

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }
}
