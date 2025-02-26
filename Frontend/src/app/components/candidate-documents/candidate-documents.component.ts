import { Component } from '@angular/core';

@Component({
  selector: 'app-candidate-documents',
  templateUrl: './candidate-documents.component.html',
  styleUrls: ['./candidate-documents.component.css']
})
export class CandidateDocumentsComponent {
  documents = [
    { id: 1, name: 'CV.pdf', type: '📄 CV', uploadedAt: '2025-02-12' },
    { id: 2, name: 'Lettre_motivation.pdf', type: '📝 Lettre de motivation', uploadedAt: '2025-02-10' }
  ];

  newDocument: File | null = null;

  uploadDocument(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.documents.push({
        id: this.documents.length + 1,
        name: file.name,
        type: '📄 Autre',
        uploadedAt: new Date().toISOString().split('T')[0]
      });
    }
  }

  deleteDocument(id: number) {
    this.documents = this.documents.filter(doc => doc.id !== id);
  }
  viewDoc(id: number) {
    alert(`Affichage de l'annonce ID: ${id}`);
  }
}
