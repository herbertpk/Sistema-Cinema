package sistema;

import javax.swing.*;
import java.io.*;


public class Recuperador {
    Recuperador(){}

    public SistemaFilmeMap recuperar(SistemaFilmeMap sistema){
        if(new File("Sistema").canRead()){

            try(FileInputStream inC = new FileInputStream("Sistema");
                ObjectInputStream objInc = new ObjectInputStream(inC)){


                return (SistemaFilmeMap) objInc.readObject();


            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"não foi possivel recuperar os dados erro:"+e);
            } catch (ClassNotFoundException error) {
                JOptionPane.showMessageDialog(null,"ocorreu um erro inesperado");
            }

        }else{
            JOptionPane.showMessageDialog(null,"não foi possivel recuperar os dados, não foi possivel ler o arquivo de dados");

        }
        return sistema;
    }
}
