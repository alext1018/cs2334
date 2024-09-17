import java.util.*;

public class Sentence {
    private List<Word> _sentence;
    private String _sentenceStr;
    private int _pos;
    private Map<Word, Integer> wordFreq;

    public Sentence(String _sentenceStr, int _pos) {
        if(_sentenceStr == null) {
            throw new NullPointerException();
        } else if(_pos < 0) {
            throw new IllegalArgumentException();
        }
        this._pos = _pos;
        this._sentenceStr = _sentenceStr;
        this._sentence = new ArrayList<>();
        this.wordFreq = new HashMap<>();      String[] words = _sentenceStr.split(" ");
        for(int i = 0; i < words.length; i++) {
            Word word = new Word(words[i], i);
            _sentence.add(word);
        }
        for(Word word: _sentence) {
            Word insertWord = new Word(word.toLowerCase(), word.position());
            wordFreq.put(word, 1 + wordFreq.getOrDefault(insertWord, 0));
        }
    }
    public int length() {
        return _sentence.size();
    }

    
    public String toString() {
        return _sentenceStr;
    }
    public int position() {
        return _pos;
    }
    public Word get(int idx) {
        return _sentence.get(idx);
    }
    public List<Integer> getWordIndices(Word w) {
        if(w == null) {
            throw new NullPointerException();
        }
        List<Integer> wordIndices = new ArrayList<>();
        for(int i = 0; i < _sentence.size(); i++) {
            if(_sentence.get(i).toString().toLowerCase().equals(w.toString().toLowerCase())) {
                wordIndices.add(i);
            }
        }
        return wordIndices;
    }
    public Map<Word, Integer> wordFrequency() {
        Map<Word, Integer> wordFreq = new HashMap<Word, Integer>();
        int count =0;
        for(int i =0;i<_sentence.size();i++) {
            if (wordFreq.containsKey(_sentence.get(i))) {
                count++;
                wordFreq.put(_sentence.get(i),count);

        }
            else if(!(wordFreq.containsKey(_sentence.get(i)))){
            	
                wordFreq.put(_sentence.get(i),count);
            }
        }
        return wordFreq;
    }
    	
    public Word mostFrequent() {
		return null;
       
    }
}
