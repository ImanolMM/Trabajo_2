public class OrderedCircularLinkedList<T> extends CircularLinkedList<T> implements OrderedListADT<T>{
	
	public void add(T elem){ //TODO preguntar si hay que hacer un CompareTo o si van a ser siempre numeros
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node act = last;
		Node ant = last;
		Node nuevo = new Node(elem);
		boolean añadido = false;
		if (last != null){
			act = last.next;
			while (act != last && !añadido){
				if (elem.compareTo(act.data.toString()) < 0 ){
					if (act == last.next){
						nuevo.next = act;
						last.next = nuevo;
						last = nuevo;
					}else{
						nuevo.next = act;
						ant.next = nuevo;
					}
					count++;
					añadido = true;
				}else{
					ant = act;
					act = act.next;
				}
			}
		}else{
			last= nuevo;
			last.next = nuevo;
			count ++;
		}
	}

}
