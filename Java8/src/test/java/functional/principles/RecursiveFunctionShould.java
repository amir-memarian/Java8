package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursiveFunctionShould {
    //TODO : sum(5) 1+2+3+4+5=15


    @Test
    void call_itself() {
        int limit = 5;

        assertThat(itrativeSum(limit)).isEqualTo(15);
        assertThat(recursiveSum(limit)).isEqualTo(15);
        assertThat(tailRecursiveSum(0,limit)).isEqualTo(15);
    }

    private int tailRecursiveSum(int sum,int limit) {
        if (limit == 0){
            return sum;
        }
        return tailRecursiveSum(sum + limit,limit - 1);
    }

    private int recursiveSum(int limit) {
        if (limit == 0){
            return limit;
        }
        return limit + recursiveSum(limit - 1);
    }

    private int itrativeSum(int limit) {
        int sum = 0;
        for(int index=0;index<=limit;index++){
            sum += index;
        }
        return sum;
    }
}
