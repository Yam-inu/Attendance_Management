import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.sql.Timestamp;


public class AttendMng { // Attendance Management
    public static void main(String args[]) throws FileNotFoundException{
        String[][] studentsData = new String[50][5];
        studentsData = csvToArray2("../src/students.csv");
        
        showArray2(studentsData);
        
        System.out.println(readTimeStamp());
        
    }

    public static String[][] csvToArray2(String path) throws FileNotFoundException{
        String[] readData = new String[50];
        String[][] readDataArray2 = new String[50][5];
        FileInputStream fis = new FileInputStream(path);
        int readIndex = 0;
        
        // ファイルの読み込み
		try {
			BufferedReader b_reader = new BufferedReader(new InputStreamReader(fis, "Shift-JIS"));
			try (Scanner scanner = new Scanner(b_reader)) {
				while (scanner.hasNext()) { //次に読み込むべき行があるか判定
					readData[readIndex] = scanner.next();
                    readIndex++;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

        // 一次元配列から二次元配列に変換
        for(int i=0; i<readData.length; i++){
            if(readData[i]==null)break;
            for(int j=0; j<5; j++){
                readDataArray2[i][j] = readData[i].split(",")[j];
            }
        }
        return readDataArray2;
    }

    public static void showArray2(String[][] inputArray2){
        for(String[] inputArray : inputArray2){
            if(inputArray[0]==null)break;
            for(String inputData : inputArray){
                if(inputData==null)break;
                System.out.print(inputData+" ");
            }
            System.out.println();
        }
    }

    public static String readTimeStamp(){ // 戻り値:yyyy-mm-dd hh:mm:ss.fffffffff
        //協定世界時のUTC 1970年1月1日深夜零時との差をミリ秒で取得
        long millis = System.currentTimeMillis();
        //ミリ秒を引数としてTimestampオブジェクトを作成
        Timestamp timestamp = new Timestamp(millis);

        //Timestampオブジェクトの値
        // System.out.println(timestamp.toString());
        return timestamp.toString();
    }
}
