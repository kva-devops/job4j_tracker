package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private static EasyStream eStream;

    private final List<Integer> buffer;

    private EasyStream(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public static EasyStream of(List<Integer> source) {
            eStream = new EasyStream(source);
        return eStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> buffBefore = eStream.buffer;
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            buffAfter.add(fun.apply(elem));
        }
        return EasyStream.of(buffAfter);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> buffBefore = eStream.buffer;
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            if (fun.test(elem)) {
                buffAfter.add(elem);
            }
        }
        return EasyStream.of(buffAfter);
    }

    public List<Integer> collect() {
        return eStream.buffer;
    }
}
