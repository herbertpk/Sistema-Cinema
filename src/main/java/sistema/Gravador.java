package sistema;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Gravador {

    SistemaFilmeMap sistema;

    public Gravador(SistemaFilmeMap sistema){
        this.sistema = sistema;
    }

    public void salvarLista() {

        try(FileOutputStream out = new FileOutputStream("Sistema");
            ObjectOutputStream objOut = new ObjectOutputStream(out)){

            objOut.writeObject(sistema);

        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"não foi possivel salvar erro:"+e);
            return;
        }
        JOptionPane.showMessageDialog(null,"Filmes salvos com sucesso!");
    }
}
