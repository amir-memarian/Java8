package functional.principles;

// function : SAM (single Abstract Method)
@FunctionalInterface
interface Operation{
    int applyOperation(int number); // method Abstract yek doneh bashad.
    default int another(int number){
        return  0;
    }
}
