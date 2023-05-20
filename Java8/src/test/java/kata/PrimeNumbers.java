package kata;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PrimeNumbers {
    private boolean isPrime(int number) {
        return IntStream.range(2,number).noneMatch(integer -> number % integer == 0);
    }

    public List<Integer> calculate(int limit) {
        return IntStream.range(2, limit)
                .boxed()
                .filter(this::isPrime)
                .collect(toList());
    }
}
