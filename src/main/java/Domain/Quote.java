package Domain;

public class Quote {

    private String quoteText;

    public Quote(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getText(){
        return quoteText.trim();
    }

    @Override
    public boolean equals(Object o){
        return ((o instanceof Quote) && (((Quote) o).getText().equals(getText())));
    }

}