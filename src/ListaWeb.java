import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class ListaWeb extends UnorderedCircularLinkedList<Web>{

    public ListaWeb (){
        last = null;
        descr = "";
        count = 0;
    }

    public int obtenerNumWebs (){
        return this.count;
    }

    public void añadirWeb (Web web) {
            this.addToRear(web);
    }

    public Web devolverWebPorPos (int pos){
        Node <Web> act = last.next;
        for (int i = pos ; pos != 0; pos --){
            act = act.next;
        }
        return act.data;
    }

    public void quitarWeb (int id){
        Node <Web> act = last;
        Node <Web> ant = last;
        boolean quitado = false;

        if (last != null){
            act = act.next;
            while (act != last && !quitado){
                if (act.data.obtenerId() == id){
                    if (act == last){
                        ant.next = act.next;
                        last = ant;
                    }else{
                        ant.next = act.next;
                    }
                }else{
                    ant = act;
                    act = act.next;
                }
            }
        }
    }

    public void añadirWebYAlArchivo (Web web){
        this.añadirWeb(web);
        try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\src\\index-2022-2023", true);
            PrintWriter out = new PrintWriter(fw))
        {
            out.println();
            out.print(web.obtenerId() + ":"+ web.obtenerNombre());
        } catch (IOException e){

        }
    }
    
    public ArrayList <Web> obtenerArray (){
        ArrayList <Web> lista = new ArrayList<Web>();
        Node <Web> act = last.next;
        for (int i = 1; i <= count; i++){
            lista.add (act.data);
            act = act.next;
        }
        return lista;
    }
}
