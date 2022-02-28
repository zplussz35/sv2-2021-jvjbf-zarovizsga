package sentencetransformer;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        Character firstChar = sentence.trim().charAt(0);
        Character lastChar = sentence.trim().charAt(sentence.trim().length() - 1);

        if (!Character.isAlphabetic(firstChar) || Character.toUpperCase(firstChar) != firstChar) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (!lastChar.equals('!') && !lastChar.equals('?') && !lastChar.equals('.')) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
        String[] parts = sentence.trim().split(" ");
        if (parts.length > 4) {
            return parts[0] + " ... " + parts[parts.length - 1];
        }
        return sentence;
    }


}
