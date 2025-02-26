import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isMenuOpen = false;

  constructor(private router: Router){}

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }
  
  logout(): void {
    // Supprimer le token JWT du localStorage
    localStorage.removeItem('jwtToken');
    // Rediriger vers la page de connexion
    this.router.navigate(['/login']);
  }
}
