import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-admin-delete',
  templateUrl: './admin-delete.component.html',
  styleUrls: ['./admin-delete.component.css']
})
export class AdminDeleteComponent {
  @Input() itemId!: number;  // ID de l'élément à supprimer
  @Input() itemType!: string;  // Type d'élément (Annonce, Candidat, etc.)
  @Output() deleted = new EventEmitter<number>(); // Événement à envoyer après suppression

  confirmDelete() {
    this.deleted.emit(this.itemId);  // Émettre l'ID pour suppression
  }

  cancelDelete() {
    this.deleted.emit(-1);  // -1 signifie annulation
  }
}
