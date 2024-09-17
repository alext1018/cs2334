import java.util.HashSet;

public class Word {
    private String _word;
    private int _pos;

    public Word(String _word, int _pos) {
        if(_word == null) {
            throw new NullPointerException();
        } else if(_pos < 0) {
            throw new IllegalArgumentException();
        }
        this._word = _word;
        this._pos = _pos;
    }
    public int length() {
        return _word.length();
    }

    public String toString() {
        return _word;
    }
    public int position() {
        return _pos;
    }
    public String toLowerCase() {
        return _word.toLowerCase();
    }

   
    public int uniqueChars() {
        String words = _word.toLowerCase();
        HashSet<Character> s = new HashSet<>();
        for(int i = 0; i < words.length(); i++) {
            s.add(words.charAt(i));
        }
        return s.size();
    }

    @Override
    public int hashCode() {
        return _word.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            throw new NullPointerException();
        }
        else if(obj.getClass() != this.getClass()) {
            return false;
        }
        obj = (Word)obj;
        return this.toLowerCase().equals(((Word) obj).toLowerCase());
    }
}
