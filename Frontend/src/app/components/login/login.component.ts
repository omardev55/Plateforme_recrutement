import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  isPasswordVisible: boolean = false; // 🔹 Ajout de cette variable
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  togglePasswordVisibility(): void { // 🔹 Ajout de cette fonction
    this.isPasswordVisible = !this.isPasswordVisible;
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { username, password } = this.loginForm.value;

      this.authService.login(username, password).subscribe({
        next: (response) => {
          console.log('✅ Connexion réussie', response);
          this.authService.saveToken(response.token); // 🔹 Vérifier si `saveToken` existe bien dans `auth.service.ts`

          // 🔹 Vérifier le rôle de l'utilisateur
          const userRole = response.userType; // Assurez-vous que l'API retourne `userType`
          if (userRole === 'CANDIDAT') {
            this.router.navigate(['/jobs']); // 🚀 Redirection vers Home
          } else if (userRole === 'RECRUTEUR') {
            this.router.navigate(['/recruteurdashboard']); // 🚀 Redirection vers le Dashboard Recruteur
          }
        },
        error: (error) => {
          console.error('❌ Erreur de connexion', error);
          this.errorMessage = 'Identifiants incorrects. Veuillez réessayer.';
        }
      });
    } else {
      console.log('❌ Formulaire invalide');
      this.errorMessage = 'Veuillez remplir tous les champs.';
    }
  }
}
