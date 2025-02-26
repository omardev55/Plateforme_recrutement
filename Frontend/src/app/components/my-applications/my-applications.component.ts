import { Component } from '@angular/core';

@Component({
  selector: 'app-my-applications',
  templateUrl: './my-applications.component.html',
  styleUrls: ['./my-applications.component.css']
})
export class MyApplicationsComponent {
  applications = [
    {
      jobTitle: "Développeur Full Stack",
      company: "TechCorp",
      date: new Date('2024-02-01'),
      status: "En attente"
    },
    {
      jobTitle: "Data Analyst",
      company: "DataSoft",
      date: new Date('2024-01-20'),
      status: "Acceptée"
    },
    {
      jobTitle: "UI/UX Designer",
      company: "Creative Studio",
      date: new Date('2024-01-15'),
      status: "Refusée"
    }
  ];
}
