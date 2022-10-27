import java.util.ArrayList;
public class ListaPClave extends UnorderedCircularLinkedList<PClave>{

    public ListaPClave (){
        last = null;
        descr = "";
        count = 0;
    }

    public void añadirPalabra (PClave palabra){
        this.addToRear(palabra);
    }

    public int obtenerNumPalabras (){
        return this.count;
    }

    public PClave obtenerPalabraPorPos (int pos){
        //precondición: la posición es válida
        Node <PClave> act = last.next;
            for (int i = pos ; pos != 0; pos --){
                act = act.next;
            }
            return act.data;
    }

    public ArrayList <PClave> obtenerArray(){
        ArrayList <PClave> lista = new ArrayList<PClave>();
        Node <PClave> act = last.next;
        for (int i = 1; i <= count; i++){
            lista.add (act.data);
            act = act.next;
        }
        return lista;
    }

}
