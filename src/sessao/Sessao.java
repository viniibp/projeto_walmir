package sessao;

import models.Usuario;

public class Sessao {
    private static Usuario sessao;
    
    public static Usuario Logado(){
        return sessao;
    }
    
    public static void StartSession(Usuario user){
        sessao = user;
    }
    
    public static void EndSession(){
        sessao = null;
        System.gc();
    }

}
