package RMI;

import base.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * @author Ise
 * 
 * Classe de interface do SERVIDOR.
 */
public interface InterfaceServidor extends Remote {

    boolean adicionar_item(Itens item, InterfaceCli referenciaCli) throws RemoteException;
    
    boolean deletar_item(Itens item, InterfaceCli referenciaCli) throws RemoteException;
    
    ArrayList<Itens> consultar_item(String categoria, String nome, InterfaceCli referenciaCli) throws RemoteException;
		
    boolean comprar_item(ItensVendidosComprados item, InterfaceCli referenciaCli) throws RemoteException;
		
    boolean registro_interesse(Interesse interesse, InterfaceCli referenciaCli) throws RemoteException;
        
    boolean validarItem(String _codigoItem)throws RemoteException;
}
