import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    private List<Sentence> _document;
    private String _documentStr;
    private Map<Word, Integer> wordFreq;

    public Document(String document) {
        if(document == null) {
            throw new NullPointerException();
        }
       
        else {
        	List<Sentence> one =new ArrayList<>();
        	List<String> split = new ArrayList<>(Arrays.asList(document.split("\\.")));
        	for(int i=0;i<split.size();i++) {
        		Sentence sec = new Sentence(split.get(i),i);
        	}
        	_document = one;
        	_documentStr=document;
        }
    }
    public int length() {
        return this._document.size();
    }

    @Override
    public String toString() {
        return _documentStr;
    }
    public int getNumWords() {
        int sum = 0;
        for(int i =0;i<_document.size();i++) {
           
        }
        return sum;
    }
    public Sentence get(int idx) {
        return _document.get(idx);
    }
    public Map<Word, Integer> wordFrequency() {
        return wordFreq;
    }
}
