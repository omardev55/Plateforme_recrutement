import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  private apiUrl = 'http://localhost:9090/api/annonces'; // 🔹 Remplace par ton URL backend

  constructor(private http: HttpClient) {}

  ajouterAnnonce(annonceData: any): Observable<any> {
    const token = localStorage.getItem('jwtToken');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    
    return this.http.post<any>(this.apiUrl, annonceData, { headers }).pipe(
      catchError(error => {
        console.error('Erreur lors de l’ajout de l’annonce', error);
        return throwError(error);
      })
    );
  }

  getAnnonces(): Observable<any[]> {
  //   const token = localStorage.getItem('jwtToken');
  //   const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    return this.http.get<any[]>(this.apiUrl).pipe(
      catchError(error => {
        console.error('Erreur lors de la récupération des annonces', error);
        return throwError(error);
      })
    );
  }
}

