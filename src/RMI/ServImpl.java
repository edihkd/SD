package RMI;

import base.Interesse;
import base.Itens;
import base.ItensVendidosComprados;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import vendaitens.VendaItensRMI_Servidor;

/**
 * @author Ise
 * 
 * Classe servente do SERVIDOR.
 * Ela serve como intermediária de comunicacão entre a classe principal do SERVIDOR e a classe CLIENTE.
 * 
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServidor {
    
    private VendaItensRMI_Servidor servidor = null;
    /**
     * Construtora.
     * 
     * @param servidor VendaItensRMI_Servidor - Armazena a referencia da instancia SERVIDOR que o criou.
     * @throws RemoteException 
     */
    public ServImpl(VendaItensRMI_Servidor servidor) throws RemoteException{
        this.servidor = servidor;
    }
    /**
     * Recebe chamada do CLIENTE para adicionar itens a venda.
     * 
     * @param item Itens - Objeto contendo as informações do item colocado a venda.
     * @param referenciaCli InterfaceCli - Interface do processo cliente que fez a chamada
     * @return               boolean - Informando se item foi adicionado ou não
     * @throws RemoteException 
     */
    public boolean adicionar_item(Itens item, InterfaceCli referenciaCli) throws RemoteException{
        return servidor.adicionar_item(item);
    }
    /**
     * Recebe chamada do CLIENTE para remover item da lista de itens a venda.
     * 
     * @param item Itens - Objeto contendo as informações do item a ser removido.
     * @param referenciaCli InterfaceCli - Interface do processo cliente que fez a chamada
     * @return               boolean - Informando se item foi removido ou não.
     * @throws RemoteException 
     */    
    public boolean deletar_item(Itens item, InterfaceCli referenciaCli) throws RemoteException{
        return servidor.deletar_item(item);
    }
    
    /**
     * Recebe chamada do CLIENTE para pesquisa de itens a venda, contendo nome e categoria pesquisadas.
     * 
     * @param categoria String - Categoria de pesquisa do item
     * @param nome String - Nome (ou parte do nome) de pesquisa do item
     * @param referenciaCli InterfaceCli - Interface do processo cliente que fez a chamada
     * @return               ArrayList<Itens> - Lista de itens encontrados com os filtros pesquisados
     * @throws RemoteException 
     */
    public ArrayList<Itens> consultar_item(String categoria, String nome, InterfaceCli referenciaCli) throws RemoteException{
        return servidor.consultar_item(categoria, nome);
    }
    
    /**
     * Recebe chamada do CLIENTE com proposta de compra de item.
     * 
     * @param item ItensVendidosComprados - Informações do item e dos dados do cartão do comprador
     * @param referenciaCli InterfaceCli - Interface do processo cliente que fez a chamada
     * @return              boolean - Informando se a venda foi aceita pelo vendedor ou não.
     * @throws RemoteException 
     */
    public boolean comprar_item(ItensVendidosComprados item, InterfaceCli referenciaCli) throws RemoteException{
        return servidor.comprar_item(item);
    }
    
    /**
     * Recebe chamada do CLIENTE para registro de interesse em um item.
     * 
     * @param interesse Interesse - Objetivo contendo as informações de interesse (categoria do item, nome do item, referencia do comprador).
     * @param referenciaCli InterfaceCli - Interface do processo cliente que fez a chamada
     * @return              boolean - Informando se o registro foi efetuado com sucesso ou não.
     * @throws RemoteException 
     */
    public boolean registro_interesse(Interesse interesse, InterfaceCli referenciaCli) throws RemoteException{
        return servidor.registrarInteresse(interesse);
    }
    /**
     * Recebe chamada do CLIENTE para confirmar disposição de determinado item para compra.
     * 
     * @param _codigoItem String - Código do item a ser confirmado
     * @param referenciaCli InterfaceCli - Interface do processo cliente que fez a chamada
     * @return              boolean - Informando se o item ainda está disponível para compra ou não.
     * @throws RemoteException 
     */
    public boolean validarItem(String _codigoItem)throws RemoteException{
        return servidor.validarItem(_codigoItem);
    }
    
}

