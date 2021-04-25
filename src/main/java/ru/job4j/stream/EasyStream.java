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
            EasyStream eStream = new EasyStream(this);
            eStream.buffer = buffer;
            return eStream;
        }
    }

    private EasyStream(Builder builder) {
        buffer = builder.buffer;
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder().buildBuffer(source).build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> buffBefore = new Builder().buildBuffer(buffer).build().buffer;
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            buffAfter.add(fun.apply(elem));
        }
        return new Builder().buildBuffer(buffAfter).build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> buffBefore = new Builder().buildBuffer(buffer).build().buffer;
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            if (fun.test(elem)) {
                buffAfter.add(elem);
            }
        }
        return new Builder().buildBuffer(buffAfter).build();
    }

    public List<Integer> collect() {
        return new Builder().buildBuffer(buffer).build().buffer;
    }
}
