public class Main{

    /*
     ***********************************************
     * This is the driver code. Don't change it!!!
     * *********************************************
     */
    public static void main(String[] args){
        /*
         * Format of the 'args' array: `<Number of Travelers> <Destination> <Trip Type>` `<Number of Travelers> <Destination> <Trip Type>` `<Number of Travelers> <Destination> <Trip Type>`
         *  Example: [3 Paris round, 4 Cairo round, 1 Tokyo one-way]
         * 
         * The code evaluator will execute this code by using the command 
         * java -jar dist/lib/dist.jar '3 Paris one-way' '2 Tokyo one-way'
         * 
         * So ithe value of the variable "input" given below will be the string "3 Paris one-way" the first time and "2 Tokyo one-way" the second time as the loop executes.
         * 
         */
        for (String input : args) {
            handle(input);
        }
    }

    /*
     * This method parses each input and assigns it into different variables.
     * 
     * The value of the function parameter "input" will be of the format - "3 Paris one-way". 
     * We split the string and retrieve the input data appropriately. 
     * Once retrieved, it is available as String data for you to implement the solution.
     *  
     */
    private static void handle(String input) {
        String[] inputList = input.trim().split(" ");
        String noOfTravelers = inputList[0];
        String destination = inputList[1];
        String tripType = inputList[2];

        /*
         * Implementation of the solution should begin after this. Please make sure you convert the variables into appropriate data types required for the solutioning. 
         */

    }

}
