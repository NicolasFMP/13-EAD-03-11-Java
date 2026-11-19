/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author alexs
 */
public class Main {
    public static void main(String[] args){
        /*
        String nome = "Rodrigo";
        System.out.println(nome);

        Servico servico = new Servico(1, "barba", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());

        Cliente cliente = new Cliente(1, nome, "Rua da palhoça", "434343434343");
        System.out.println(cliente.getNome());

        Usuario usuario = new Usuario (1, "barbeiro", "senha");
        System.out.println(usuario.getNome());*/
        
        String nome = "Rodrigo";
        System.out.println(nome);
        
        Servico servico = new Servico(1, "barba", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1, "Jorge","Rua tesla 95", "95445866");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario (1, "barbeiro", "senha");
        System.out.println(usuario);
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "25/10/2024 11:20", "Corte foda");
        System.out.println(agendamento.getCliente().getNome());
   
    }
}
