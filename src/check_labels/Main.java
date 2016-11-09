package check_labels;

/**
 * Created by User on 02.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        Object b = new Object();
        Integer a = (Integer) b;
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for(TextAnalyzer textAnalyzer: analyzers){
            Label label = textAnalyzer.processText(text);
            if(label!=Label.OK) return label;
        }

        return Label.OK;
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    abstract class KeywordAnalyzer implements TextAnalyzer{
        protected abstract String[] getKeywords();

        protected abstract Label getLabel();

        public Label processText(String text){
            String[] keywords = this.getKeywords();
            for(String s: keywords){
                if(text.contains(s)) return this.getLabel();
            }

            return Label.OK;
        }


    }

    class SpamAnalyzer extends KeywordAnalyzer{
        private String[] keywords;

        public SpamAnalyzer(String[] keywords){
            this.keywords = new String[keywords.length];
            System.arraycopy(keywords, 0, this.keywords, 0, keywords.length);
        }

        public Label getLabel(){
            return Label.SPAM;
        }

        public String[] getKeywords(){
            return this.keywords;
        }


    }

    class NegativeTextAnalyzer extends KeywordAnalyzer{
        public NegativeTextAnalyzer(){

        }

        public Label getLabel(){
            return Label.NEGATIVE_TEXT;
        }

        public String[] getKeywords(){
            String[] keywords = {":(", "=(", ":|"};
            return keywords;
        }

    }

    class TooLongTextAnalyzer implements TextAnalyzer{
        int maxLength;

        public TooLongTextAnalyzer(int length){
            this.maxLength = length;
        }

        public Label processText(String text){
            if(text.length() > maxLength) return Label.TOO_LONG;
            else return Label.OK;
        }


    }
}
