public class SequentialExecution {

    public static void printEvenNumbers(){
        // Printing Even Numbers
        for(int i=0; i<100; i++){
            if(i % 2 == 0)
                System.out.println("Even Number: " + i);
        }
    }

    public static void printOddNumbers(){
        // Printing the Odd Numbers
        for(int i=0; i<100; i++){
            if(i % 2 == 1)
                System.out.println("Odd Number: " + i);
        }
    }
    public static void main(String[] args) {
        printEvenNumbers();

        printOddNumbers();
    }
}
