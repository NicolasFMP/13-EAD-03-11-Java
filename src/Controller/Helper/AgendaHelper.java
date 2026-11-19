/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexs
 */
public class AgendaHelper implements IHelper{
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    
    
    
    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        for(Agendamento agendamento : agendamentos){
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }
    }
    
    public void preencherClientes(ArrayList<Cliente> clientes){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        for(Cliente cliente : clientes){
            comboBoxModel.addElement(cliente);
        }
    }

    public void preencherServico(ArrayList<Servico> servicos) {
       DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
       for(Servico servico : servicos){
           comboBoxModel.addElement(servico);
       }
    }
   
    public Servico obterServico(){
        System.out.println("View get: " + view.getjComboBoxServico().getSelectedItem());
        return (Servico) view.getjComboBoxServico().getSelectedItem();
        
    }
    
    public Cliente obterCliente() {
        return (Cliente) view.getjComboBoxCliente().getSelectedItem();
    }
    
    public void setarValor(float valor){
        view.getjTextFieldValor().setText(valor+"");
    }
    
    public void setarIdCliente(int id){
        view.getTextFieldId().setText(id+"");
    }

    @Override
    public Agendamento obterModelo() {
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String stringValor = view.getjTextFieldValor().getText();
        float valor = Float.parseFloat(stringValor);
        String data = view.getTextFieldData().getText();
        String hora = view.getTextFieldHora().getText();
        String dataHora = data + " " + hora;
        String observacoes = view.getjTextArea1().getText();
        
        Agendamento agendamento = new Agendamento(0, cliente, servico, valor, dataHora, observacoes);
        return agendamento;
        
    }

    @Override
    public void limparTela() {
        view.getTextFieldId().setText("");
        view.getjTextArea1().setText("");
        view.getTextFieldHora().setText("");
        view.getTextFieldData().setText("");
        
    }
}
    