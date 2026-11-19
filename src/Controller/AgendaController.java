/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author alexs
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        AgendamentoDAO agendamentoDao = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDao.selectAll();
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> cliente = clienteDAO.selectAll();
        helper.preencherClientes(cliente);
    }
    
    public void atualizaServico(){
        ServicoDAO  servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        helper.preencherServico(servicos);
    }
     
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void atualizaIdCliente(){
        Cliente cliente = helper.obterCliente();
        helper.setarIdCliente(cliente.getId());
    }
    
    public void agendar(){
        Agendamento agendamento = (Agendamento) helper.obterModelo();
        new AgendamentoDAO().insert(agendamento);
        atualizaTabela();
        helper.limparTela();
    }
}
