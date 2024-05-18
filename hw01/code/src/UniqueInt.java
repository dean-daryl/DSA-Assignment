import java.io.*;

public class Main {
    private static int fileLength;
    private static String[] values;
//  get file with its absolute file path... replace this with the current file
    private static File file = new File("C:\\Users\\deand\\Downloads\\DSA ASSIGNMENT\\hw01\\sample_inputs\\small_sample_input_01.txt");
//Get file size to allocate size to array
    public static int getFileSize(BufferedReader bufferedReader) throws IOException {
        int lines = 0;
        while (bufferedReader.readLine() != null) {
            lines++;
        }
        return lines;
    }
//Read through the file and add input to an array
    public static String[] readFileContent(BufferedReader bufferedReader, String[] stringArray) throws IOException {
        int j = 0;
        bufferedReader.close(); // Close the reader to reset it
        bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null && j < fileLength) {
            stringArray[j] = line;
            j++;
        }
        return stringArray;
    }
//use a hash set to filter out the repeated elements
    public static String[] filterArray(String[] unfilteredArray) {
        // Create an array to store unique elements
        String[] uniqueArray = new String[unfilteredArray.length];
        int count = 0;

        // Iterate through the unfilteredArray
        for (String element : unfilteredArray) {
            boolean isUnique = true;

            //Nested for loop to check if the element already exists in the unique array
            for (int i = 0; i < count; i++) {
                if (uniqueArray[i] != null && uniqueArray[i].equals(element)) {
                    isUnique = false;
                    break;
                }
            }

            // If the element is unique, add it to the unique array
            if (isUnique) {
                uniqueArray[count] = element;
                count++;
            }
        }

        // Trim the unique array to remove null values
        String[] trimmedArray = new String[count];
        for(int j = 0; j< count; j++){
            if(uniqueArray[j] != null){
                trimmedArray[j] = uniqueArray[j];
            }
        }
        return trimmedArray;
    }
//    Sort the array  starting from small -> large
    public static String[] bubbleSort(String[] arr){
//        bubble sort algorithm to sort the array
        String tmp;
        for (int i =0; i<arr.length;i++){
            for (int j = i+1; j< arr.length; j++){
                if(Integer.parseInt(arr[i]) > Integer.parseInt(arr[j])){
                    tmp = (arr[i]);
                    (arr[i]) = (arr[j]);
                    (arr[j]) = tmp;
                }
            }
        }
//        return sorted array
        return arr;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        fileLength = getFileSize(br);
        br.close(); // Close the reader before reopening
        br = new BufferedReader(new FileReader(file));
        values = new String[fileLength];
        values = readFileContent(br, values);
        String[] uniqueValues = filterArray(values);
        String[] finalSortedArray = bubbleSort(uniqueValues);
        // Printing the content of the array
        for (int j = 0; j < uniqueValues.length; j++) {
            System.out.println(uniqueValues[j]);
        }
    }
}
