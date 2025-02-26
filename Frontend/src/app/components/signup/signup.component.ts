import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';  // Assurez-vous que le chemin est correct
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  signupForm: FormGroup;
  isPasswordVisible: boolean = false;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.signupForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      nom: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]], // ✅ Vérifie que l'email est bien défini
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required]],
      role: ['CANDIDAT', [Validators.required]], // 📌 Par défaut, "CANDIDAT"
      age: [''], // Optionnel
      entreprise: [''] // Optionnel (uniquement pour les recruteurs)
    }, { validators: this.passwordMatchValidator });
  }

  // ✅ Vérification si les mots de passe correspondent
  passwordMatchValidator(formGroup: FormGroup): any {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { passwordsDontMatch: true };
  }

  togglePasswordVisibility(): void {
    this.isPasswordVisible = !this.isPasswordVisible;
  }

  // ✅ Fonction appelée lors du clic sur "Sign Up"
  onSubmit(): void {
    if (this.signupForm.valid) {
        let signupData = { ...this.signupForm.value };

        // 🛠 Si `age` ou `entreprise` sont vides, on met `null`
        if (signupData.age === "") {
            signupData.age = null;
        }
        if (signupData.entreprise === "") {
            signupData.entreprise = null;
        }

        console.log("📩 Données envoyées au backend :", signupData);

        this.authService.register(signupData).subscribe({
            next: (response) => {
                console.log('✅ Inscription réussie', response);
                this.router.navigate(['/login']);
            },
            error: (error) => {
                console.error('❌ Erreur d\'inscription', error);
                this.errorMessage = error.error?.message || 'Une erreur est survenue.';
            }
        });
    } else {
        console.log('❌ Formulaire invalide');
        this.errorMessage = 'Veuillez remplir correctement tous les champs.';
    }
}

}
