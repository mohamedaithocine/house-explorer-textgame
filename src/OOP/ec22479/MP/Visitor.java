package OOP.ec22479.MP;

interface Visitor {
    
    void tell(String messageForVisitor);

    void getItems();
    
    char getChoice( // Returns visitor's choice.
                   String descriptionOfChoices,
                   char[] arrayOfPossibleChoices);
    
    boolean giveItem( // Returns true if item is accepted.
                     Item itemGivenToVisitor);
    
    boolean hasIdenticalItem( // Returns true if visitor has the identical (==) item.
                             Item itemToCheckFor);
        
    boolean hasEqualItem( // Returns true if visitor has an equal item (same name).
                         Item itemToCheckFor);
    
    void giveGold(int numberOfPiecesToGive);
        
    int takeGold( // Returns number of pieces actually obtained from visitor.
                 int numberOfPiecesToTake);
}