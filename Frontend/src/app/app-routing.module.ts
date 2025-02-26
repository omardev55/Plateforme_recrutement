import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { CandidateProfileComponent } from './components/candidate-profile/candidate-profile.component';
import { JobDetailComponent } from './components/job-detail/job-detail.component';
import { RecruiterJobListComponent } from './components/recruiter-job-list/recruiter-job-list.component';
import { RecruiterJobCreateComponent } from './components/recruiter-job-create/recruiter-job-create.component';
import { RecruiterJobEditComponent } from './components/recruiter-job-edit/recruiter-job-edit.component';
import { RecruiterJobDeleteComponent } from './components/recruiter-job-delete/recruiter-job-delete.component';
import { MyApplicationsComponent } from './components/my-applications/my-applications.component';
import { JobApplyComponent } from './components/job-apply/job-apply.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { JobFiltersComponent } from './components/job-filters/job-filters.component';
import { RecruiterJobCandidatesComponent } from './components/recruiter-job-candidates/recruiter-job-candidates.component';
import { AdminApplicationListComponent } from './components/admin-application-list/admin-application-list.component';
import { AdminCandidateListComponent } from './components/admin-candidate-list/admin-candidate-list.component';
import { AdminJobListComponent } from './components/admin-job-list/admin-job-list.component';
import { AdminDeleteComponent } from './components/admin-delete/admin-delete.component';
import { CandidateDocumentsComponent } from './components/candidate-documents/candidate-documents.component';
import { AdminRecruiterListComponent } from './components/admin-recruiter-list/admin-recruiter-list.component';
import { RecruiterJobDetailComponent } from './components/recruiter-job-detail/recruiter-job-detail.component';
import { EditCandidateProfileComponent } from './components/edit-candidate-profile/edit-candidate-profile.component';
import { RecruteurDashboardComponent } from './components/recruteur-dashboard/recruteur-dashboard.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [
  { path : '', component:HomeComponent},
  { path : 'home', component:HomeComponent},
  { path : 'signup', component:SignupComponent},
  { path : 'login', component:LoginComponent},
  { path : 'candidateprofile', component:CandidateProfileComponent},
  { path : 'jobdetails', component:JobDetailComponent},
  { path : 'recruiterjoblist', component:RecruiterJobListComponent},
  { path : 'recruiterjobcreate', component:RecruiterJobCreateComponent},
  { path: 'recruiter/job-edit/:id', component: RecruiterJobEditComponent },
  { path: 'recruiter/job-delete/:id', component: RecruiterJobDeleteComponent },
  { path: 'myapplications', component:MyApplicationsComponent},
  { path: 'jobapply', component:JobApplyComponent},
  { path: 'jobs', component:JobListComponent},
  { path: 'jobfilters', component:JobFiltersComponent},
  { path: 'candidatures', component:RecruiterJobCandidatesComponent},
  { path: 'adminapplist', component:AdminApplicationListComponent},
  { path: 'admincandidatelist', component:AdminCandidateListComponent},
  { path: 'adminjoblist', component:AdminJobListComponent},
  { path: 'admindelete', component:AdminDeleteComponent},
  { path: 'candidatedocuments', component:CandidateDocumentsComponent},
  { path: 'adminrecruiterlist', component:AdminRecruiterListComponent},
  { path: 'recruiterjobdetail', component:RecruiterJobDetailComponent},
  { path: 'editcandidateprofile', component:EditCandidateProfileComponent}, 
  { path: 'recruteurdashboard', component:RecruteurDashboardComponent},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
