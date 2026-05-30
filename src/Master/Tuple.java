package Master;
import java.util.InputMismatchException;
public class Tuple<ContentType> implements Comparable{
    ContentType first;
    ContentType second;
    public Tuple(ContentType first, ContentType second){
        this.first=first;
        this.second=second;
    }
    public boolean isComplete(){
        return (first != null && second != null);
    }
    public boolean isEmpty(){
        return (first == null && second == null);
    }
    public void setFirst(ContentType c){
        first = c;
    }
    public void setSecond(ContentType c){
        second = c;
    }
    public ContentType getFirst(){
        return first;
    }

    public ContentType getSecond() {
        return second;
    }
    //Schreibarbeit sparen.
    public ContentType first(){
        return getFirst();
    }
    public ContentType second(){
        return getSecond();
    }
    public void clear(){
        first = null;
        second = null;
    }
    public String toString(){
        return "( " + first.toString() + " , " + second.toString() + " )";
    }

    public boolean equals(int i) throws InputMismatchException {
        if (first instanceof Integer){
            return(((int)first+(int)second) == i);
        }
        throw new InputMismatchException("Found " + first.getClass() + ", required: Integer");
    }

    @Override
    public int compareTo(Object o) {
        if (o!= null && o.getClass() == first.getClass()){
            //Hope the creator of these classes implemented comparable :D
            @SuppressWarnings("unchecked")
            Comparable<Object> comparableFirst = (Comparable<Object>) first;
            return comparableFirst.compareTo(o);
        }
        throw new ClassCastException("Incompatible types for comparison");
    }
    public int compareFirst(Object o) throws InputMismatchException {
        if (o instanceof Integer && first instanceof Integer){
            if (o  == first) return 0;
            else if ((int)o > (int)first) return -1;
            else return 1;
        }
        else throw new InputMismatchException("Found " + first.getClass() + ", required: Integer");
    }
}
