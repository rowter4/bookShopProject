import { NgModule } from "@angular/core";
import { MatDialogModule } from '@angular/material/dialog';

const matModules: any[] = [
    MatDialogModule
]
  
  @NgModule({
    imports: matModules,
    exports: matModules
  })
  export class MaterialModule {}