public interface BasicGoodBehavior {

    public String toString();

    /**
     * Identifies a critical field or fields of the implementing object and ensures
     * that their content is not null.
     * 
     * @return true if identified fields are null, false otherwise
     */
    public boolean isEmpty();

}
