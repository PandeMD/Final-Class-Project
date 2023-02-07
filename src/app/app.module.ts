import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{  HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HowitworkComponent } from './pages/howitwork/howitwork.component';
import { FaqComponent } from './pages/faq/faq.component';
import { PrivatepolicyComponent } from './pages/privatepolicy/privatepolicy.component';
import { OperationalexecutiveModule } from './module/operationalexecutive/operationalexecutive.module';
import { LayoutModule } from './layout/layout.module';
import { NavbarComponent } from './share/navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SidenavComponent } from './share/sidenav/sidenav.component';
import { FinanceheadModule } from './module/financehead/financehead.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatStepperModule } from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AdminModule } from './module/admin/admin.module';
import { ChargesComponent } from './pages/charges/charges.component';
import { DocumentationComponent } from './pages/documentation/documentation.component';
import { EligibilityComponent } from './pages/eligibility/eligibility.component';
import { EmiCalculatorComponent } from './pages/emi-calculator/emi-calculator.component';
import { FeaturesComponent } from './pages/features/features.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HowToApplyComponent } from './pages/how-to-apply/how-to-apply.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { NgxSpinnerModule } from 'ngx-spinner';
import { Ng5SliderModule } from 'ng5-slider';
import { RelationshipexecutiveModule } from './module/relationshipexecutive/relationshipexecutive.module';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HowitworkComponent,
    FaqComponent,
    PrivatepolicyComponent,
    HomeComponent,
    FeaturesComponent,
    EligibilityComponent,
    EmiCalculatorComponent,
    ChargesComponent,
    HowToApplyComponent,
    HomePageComponent,
    DocumentationComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RelationshipexecutiveModule,
    OperationalexecutiveModule,
    LayoutModule,
    FormsModule,
   ReactiveFormsModule,
   HttpClientModule,
   FinanceheadModule,
   BrowserAnimationsModule,
   MatStepperModule,MatFormFieldModule, 
   AdminModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    NgxSpinnerModule.forRoot({type: 'ball-scale-multiple'}),
    Ng5SliderModule,
    // MdbCarouselModule 
  ],
 
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
