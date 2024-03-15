package fun.d001records;


import java.util.List;

public record State(String name, String capital, List<String> cities)
{

}
record State1(String name, String capital, List<String> cities) {
    State1 {

    }
}