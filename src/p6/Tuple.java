package p6;

public class Tuple<ContentType> {
    ContentType first = null;
    ContentType second = null;
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
}
