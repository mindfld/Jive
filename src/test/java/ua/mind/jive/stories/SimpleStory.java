package ua.mind.jive.stories;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static ua.mind.jive.stories.BehaviouralTestEmbedder.aBehaviouralTestRunner;

public class SimpleStory {

    private int []nums;
    private int result;
    @Test
    public void test() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("Simple.story")
                .run();
    }

    @Given("$n1 $n2 $n3 numbers")
    public void givenNumbers(int n1, int n2, int n3) {
        nums = new int[]{n1,n2,n3};
    }
    @When("i add all of them")
    public void addAll(){
        result =0;
        for (int i = 0; i < nums.length; i++) {
            result+=nums[i];
        }
    }
    @Then("I will get $expected")
    public void thenTheClockShouldLookLike(int expected) {
        assertThat(result).isEqualTo(expected);
    }
}
