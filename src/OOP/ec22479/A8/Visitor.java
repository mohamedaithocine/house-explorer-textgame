package OOP.ec22479.A8;

interface Visitor {
    
    void tell(String messageForVisitor) throws InterruptedException;

    void getItems();
    
    char getChoice( // Returns visitor's choice.
                   String descriptioOfChoices,
                   char[] arrayOfPossibleChoices);
    
    boolean giveItem( // Returns true if item is accepted.
                     Item itemGivenToVisitor) throws InterruptedException;
    
    boolean hasIdenticalItem( // Returns true if visitor has the identical (==) item.
                             Item itemToCheckFor);
        
    boolean hasEqualItem( // Returns true if visitor has an equal item (same name).
                         Item itemToCheckFor);
    
    void giveGold(int numberOfPiecesToGive);
        
    int takeGold( // Returns number of pieces actually obtained from visitor.
                 int numberOfPiecesToTake);
}