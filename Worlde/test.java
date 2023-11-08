// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;

// public class test {
//     public static void main(String[] args) {
//         ArrayList<String> words = new ArrayList<>();
//         try{
//             BufferedReader fp = new BufferedReader(new FileReader("words.txt"));
//             String line;
//             while((line = fp.readLine()) != null){
//                 words.add(line);
//             }
//             fp.close();
//         }    
//         catch(IOException e){
//             System.out.println("File not found");
//         }

//         for(int i = 0; i < words.size(); i++){
//             System.out.println(words.get(i));
//         }
//     }
// }
