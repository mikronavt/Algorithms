package CharSeq;

import java.util.Arrays;

/**
 * Created by User on 01.10.2015.
 */
public class AsciiCharSequence implements CharSequence{
    byte[] sequence;

    public AsciiCharSequence(byte[] arr){
        sequence = new byte[arr.length];
        for(int i = 0; i < arr.length; i++){
            sequence[i] = arr[i];
        }
    }

    @Override
    public String toString() {

        return new String(sequence);
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char)sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {

        return new AsciiCharSequence(Arrays.copyOfRange(sequence, start, end));
    }
}
