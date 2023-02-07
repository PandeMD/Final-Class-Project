import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LayoutRoutingModule } from './layout-routing.module';
import { AdminlayoutComponent } from './adminlayout/adminlayout.component';
import { SidenavComponent } from '../share/sidenav/sidenav.component';
import { NavbarComponent } from '../share/navbar/navbar.component';


@NgModule({
  declarations: [
    AdminlayoutComponent,
    SidenavComponent,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    LayoutRoutingModule
  ],
  exports:[
    AdminlayoutComponent,
    SidenavComponent,
    NavbarComponent
  ]
})
export class LayoutModule { }
