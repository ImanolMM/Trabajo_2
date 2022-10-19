public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node <T> nuevo = new Node<>(elem);
		if (last != null){
			nuevo.next = last .next;
			last.next = nuevo;
			count ++;
		}else{
			last = nuevo;
			last.next = nuevo;
			count++;
		}
	}//coste lineal (O(1))

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node act;
		Node <T> nuevo = new Node<>(elem);
		if (last != null){
			act = last.next;

			while (act != last){
				act = act.next;
			}
			nuevo.next = last.next;
			last.next = nuevo;
			last = nuevo;
			count ++;
		} else{
			last = nuevo;
			last.next = nuevo;
			count++;
		}
	}//coste O(n)
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
		Node act = last.next;
		Node <T> nuevo = new Node<>(elem);
		if (last.next != last){
			while (act.next != last && act.next.data != target){
				act = act.next;
			}
			nuevo.next = act.next;
			act.next = nuevo;
			count ++;

		}else{
			this.addToFront(elem);
		}

	}

}
