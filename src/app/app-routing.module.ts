import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminlayoutComponent } from './layout/adminlayout/adminlayout.component';
import { LoginComponent } from './login/login.component';
import { AdminModule } from './module/admin/admin.module';
import { BankmanagerModule } from './module/bankmanager/bankmanager.module';
import { CreditmanagerModule } from './module/creditmanager/creditmanager.module';
import { FinanceheadModule } from './module/financehead/financehead.module';
import { OperationalexecutiveModule } from './module/operationalexecutive/operationalexecutive.module';
import { RelationshipexecutiveModule } from './module/relationshipexecutive/relationshipexecutive.module';
import { AboutusComponent } from './pages/aboutus/aboutus.component';
import { ChargesComponent } from './pages/charges/charges.component';
import { ContactusComponent } from './pages/contactus/contactus.component';
import { DocumentationComponent } from './pages/documentation/documentation.component';
import { EligibilityComponent } from './pages/eligibility/eligibility.component';
import { EmiCalculatorComponent } from './pages/emi-calculator/emi-calculator.component';
import { FaqComponent } from './pages/faq/faq.component';
import { FeaturesComponent } from './pages/features/features.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HowToApplyComponent } from './pages/how-to-apply/how-to-apply.component';

import { HowitworkComponent } from './pages/howitwork/howitwork.component';
import { PrivatepolicyComponent } from './pages/privatepolicy/privatepolicy.component';

const routes: Routes = [

  {
    path: '', component: HomeComponent,
    children: [
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
      },
      {
        path: 'home', component: HomePageComponent
      },
      {
        path: 'about', component: AboutusComponent
      },
      {
        path: 'doc', component: DocumentationComponent
      },
      {
        path: 'eligibility', component: EligibilityComponent
      },
      {
        path: 'emi-calculator', component: EmiCalculatorComponent
      },
      {
        path: 'charges', component: ChargesComponent
      },
      {
        path: 'how-to-apply', component: HowToApplyComponent
      },
      {
        path: 'faq', component: FaqComponent
      },
      {
        path: 'contact', component: ContactusComponent
      },
      {
        path: 'login', component: LoginComponent
      },
    ]
  },

{
  path:"role",component:AdminlayoutComponent,
  children:[
    {
      path:"RE",loadChildren:()=>RelationshipexecutiveModule
    },
    {
      path:"OE", loadChildren:()=>OperationalexecutiveModule
    },
    {
      path:"CM", loadChildren:()=>CreditmanagerModule
    },
    {
      path:"BM", loadChildren:()=>BankmanagerModule
    },
    {
      path:"FH",loadChildren:()=>FinanceheadModule
    },
    {
      path:"Admin",loadChildren:()=>AdminModule
    },
    
  ]
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
