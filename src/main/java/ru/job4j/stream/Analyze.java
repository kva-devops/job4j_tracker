package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average().orElse(-1D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore).average().orElse(-1D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue()))
                .collect(Collectors.toList()).stream()
                // либо добавляем следующие строки, либо можно изменить порядок элементов в тесте
                .sorted(Comparator.comparing(Object::toString).reversed())
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .collect(Collectors.groupingBy(
                        Pupil::getName,
                        Collectors.summingDouble(pupil -> pupil.getSubjects().stream()
                                                            .mapToDouble(Subject::getScore)
                                                            .sum())))
                .entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("none", -1));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(), stringDoubleEntry.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("none", -1));
    }
}