package exercise;

import java.util.Arrays;
import java.util.stream.IntStream;

// BEGIN
public final class ReversedSequence implements CharSequence {

    char[] sequence;

    public ReversedSequence(String seqString) {
        char[] sequence = seqString.toCharArray();
        char tmp;
        for (int i = 0; i < sequence.length / 2; i++) {
            tmp = sequence[sequence.length - i - 1];
            sequence[sequence.length - i - 1] = sequence[i];
            sequence[i] = tmp;
        }
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return new String(this.sequence);
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (end > this.length()) {
            end = this.length();
        }
        if (start < 0) {
            start = 0;
        } else if (start > end) {
            start = end;
        }
        char[] subSequence = new char[end - start];
        for (int i = start; i < end; i++) {
            subSequence[i - start] = this.sequence[i];
        }
        ReversedSequence result = new ReversedSequence("");
        result.sequence = subSequence;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }
}
// END
