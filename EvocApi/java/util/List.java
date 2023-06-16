package co.edu.uco.evoc.init.EvocApiApplication;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E> {
    // Implementa los métodos de la interfaz List aquí

    @Override
    public int size() {
    	List<String> lista = List.of("elemento1", "elemento2", "elemento3");

    	List<String> lista = List.of("elemento1", "elemento2", "elemento3");

        // Obtener el tamaño de la lista utilizando el método personalizado
        int tamaño = obtenerTamaño(lista);

        // Imprimir el tamaño de la lista
        System.out.println("Tamaño de la lista: " + tamaño);
    }

    // Método para obtener el tamaño de una lista
    public static <T> int obtenerTamaño(List<T> lista) {
        return lista.size();
    }
        int tamaño = lista.size();

        // Imprimir el tamaño de la lista
        System.out.println("Tamaño de la lista: " + tamaño);
    }
}
        return 0;
    }

    @Override
    public boolean isEmpty() {
  
    }

    @Override
    public boolean contains(Object o) {
        // Implementa la lógica para verificar si la lista contiene el elemento especificado
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // Implementa la lógica para obtener un iterador sobre la lista
        return null;
    }

    // Implementa el resto de los métodos de la interfaz List

    // ...
}

