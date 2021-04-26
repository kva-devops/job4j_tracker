package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private final List<Integer> buffer;

    private EasyStream(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public static EasyStream of(List<Integer> source) {
        return  new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> buffBefore = List.copyOf(buffer);
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            buffAfter.add(fun.apply(elem));
        }
        return EasyStream.of(buffAfter);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> buffBefore = List.copyOf(buffer);
        List<Integer> buffAfter = new ArrayList<>();
        for (Integer elem : buffBefore) {
            if (fun.test(elem)) {
                buffAfter.add(elem);
            }
        }
        return EasyStream.of(buffAfter);
    }

    public List<Integer> collect() {
        return List.copyOf(buffer);
    }
}
