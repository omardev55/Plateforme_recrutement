import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './components/signup/signup.component';
import { CandidateProfileComponent } from './components/candidate-profile/candidate-profile.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { JobDetailComponent } from './components/job-detail/job-detail.component';
import { JobApplyComponent } from './components/job-apply/job-apply.component';
import { MyApplicationsComponent } from './components/my-applications/my-applications.component';
import { CandidateDocumentsComponent } from './components/candidate-documents/candidate-documents.component';
import { RecruiterJobListComponent } from './components/recruiter-job-list/recruiter-job-list.component';
import { RecruiterJobCreateComponent } from './components/recruiter-job-create/recruiter-job-create.component';
import { RecruiterJobEditComponent } from './components/recruiter-job-edit/recruiter-job-edit.component';
import { RecruiterJobDeleteComponent } from './components/recruiter-job-delete/recruiter-job-delete.component';
import { RecruiterJobCandidatesComponent } from './components/recruiter-job-candidates/recruiter-job-candidates.component';
import { RecruiterJobDetailComponent } from './components/recruiter-job-detail/recruiter-job-detail.component';
import { AdminCandidateListComponent } from './components/admin-candidate-list/admin-candidate-list.component';
import { AdminRecruiterListComponent } from './components/admin-recruiter-list/admin-recruiter-list.component';
import { AdminJobListComponent } from './components/admin-job-list/admin-job-list.component';
import { AdminApplicationListComponent } from './components/admin-application-list/admin-application-list.component';
import { AdminDeleteComponent } from './components/admin-delete/admin-delete.component';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { MessagesComponent } from './components/messages/messages.component';
import { FooterComponent } from './components/footer/footer.component';
import { JobFiltersComponent } from './components/job-filters/job-filters.component';
import { EditCandidateProfileComponent } from './components/edit-candidate-profile/edit-candidate-profile.component';
import { RecruteurDashboardComponent } from './components/recruteur-dashboard/recruteur-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    SignupComponent,
    CandidateProfileComponent,
    JobListComponent,
    JobDetailComponent,
    JobApplyComponent,
    MyApplicationsComponent,
    CandidateDocumentsComponent,
    RecruiterJobListComponent,
    RecruiterJobCreateComponent,
    RecruiterJobEditComponent,
    RecruiterJobDeleteComponent,
    RecruiterJobCandidatesComponent,
    RecruiterJobDetailComponent,
    AdminCandidateListComponent,
    AdminRecruiterListComponent,
    AdminJobListComponent,
    AdminApplicationListComponent,
    AdminDeleteComponent,
    NotificationsComponent,
    MessagesComponent,
    FooterComponent,
    JobFiltersComponent,
    EditCandidateProfileComponent,
    RecruteurDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
