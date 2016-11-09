package pair;

/**
 * Created by User on 28.10.2015.
 */
class Pair<T, V> {
    private final T first;
    private final V second;

    private Pair(T first, V second){
        this.first = first;
        //if(first == null) this.second = Objects.requireNonNull(second);
        //else
        this.second = second;
    }

    public T getFirst(){

        return this.first;
    }

    public V getSecond(){

        return this.second;
    }

    public static Pair of(Object first, Object second){
        return new Pair(first, second);
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(!(obj instanceof Pair)) return false;

        Pair<T, V> pr = (Pair) obj;

        if(this.first == null && pr.getFirst() != null) return false;
        if(this.first != null && pr.getFirst() == null) return false;
        if(this.second == null && pr.getSecond() != null) return false;
        if(this.second != null && pr.getSecond() == null) return false;

        if(first!=null){

         if(!first.equals(pr.getFirst())) return false;
        }
        if(second!=null){
            if(!second.equals(pr.getSecond())) return false;
        }

        return true;

    }

    public int hashCode(){
        if(this.first == null && this.second == null) return 0;
        if(first == null) return second.hashCode();
        if(second == null) return first.hashCode();

        return this.first.hashCode() + this.second.hashCode();
    }

}