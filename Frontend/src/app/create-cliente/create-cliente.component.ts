import { Component, OnInit } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClienteService } from '../cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-cliente',
  templateUrl: './create-cliente.component.html',
  styleUrls: ['./create-cliente.component.css']
})
export class CreateClienteComponent implements OnInit {

  cliente: Cliente = new Cliente();

  constructor(private clienteServicio: ClienteService, private router: Router) { }
  
  ngOnInit(): void {
  }
  isRClienteRoute(){
    return this.router.url == '/registroEntidades/newCliente';
  }
  submit(){
    this.router.navigate(['/encuesta']) //your router URL need to pass it here
  }
  save(){
    console.log("Click");
    console.log(this.cliente);
    this.clienteServicio.createCliente(this.cliente).subscribe(
      data => this.router.navigate(['/listCliente'])
    );
 

  }
}
