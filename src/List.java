import java.lang.reflect.Array;

public class List<E>{
    private Object array[];

    public List(Class<E> type) {
        this.array = new Object[10];
    }

    public int size() {
        return Array.getLength(array);
    }

    public void add(E obj){
        for (int i = 0; i < this.size(); i++) {
            if (Array.get(array, i) == null) {
                Array.set(array, i, obj);
                return;
            }
        }
        return;
    }

    public void remove(E obj){
        boolean flag = false;
        for (int i = 0; i < this.size(); i++) {
            if(Array.get(array,i) == obj)
            {
                Array.set(array, i, null);
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            System.out.println("Item not Found");
        }
        return;
    }

    public E getArray(int index){
        if(index >= 0 || index <= this.size())
        {
            Object obj =  Array.get(array, index);
            return (E) obj;
        }
        return null;
        
    }

    public void update(E obj,E obj1){
        boolean flag = false;  
        for (int i = 0; i < this.size(); i++) {
            if(Array.get(array,i) == obj)
            {
                Array.set(array, i, obj1);
                flag = true;
                break;
            }
        
        }
        if(!flag)
        {
            System.out.println("Nothing similar found to update");
        }
        return;
    }

    public void display(){
        for (int i = 0; i < this.size(); i++) {
            System.out.println(Array.get(array, i));
        }
        return;
    }

}