package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> buffer;

    static class Builder {
        private List<Integer> buffer;

        Builder buildBuffer(List<Integer> buffer) {
            this.buffer = buffer;
            return this;
        }

        EasyStream build() {
            EasyStream eStream = new EasyStream();
            eStream.buffer = buffer;
            return eStream;
        }
    }

    public List<Integer> getBuffer() {
        return buffer;
    }

    public void setBuffer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder().buildBuffer(source).build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> buffBefore = getBuffer();
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            buffAfter.add(fun.apply(elem));
        }
        setBuffer(buffAfter);
        return new Builder().buildBuffer(buffer).build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> buffBefore = getBuffer();
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            if (fun.test(elem)) {
                buffAfter.add(elem);
            }
        }
        setBuffer(buffAfter);
        return new Builder().buildBuffer(buffer).build();
    }

    public List<Integer> collect() {
        return getBuffer();
    }
}
