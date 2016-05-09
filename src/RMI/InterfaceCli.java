package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import ModelController.PassagemVendida;
/**
 * @author Ise
 * 
 * Classe de interface do CLIENTE.
 */
public interface InterfaceCli extends Remote{

    public void atualizacaoInteresse(String categoria, String nome)throws RemoteException;
    
    public boolean vender_item(PassagemVendida item) throws RemoteException;
}