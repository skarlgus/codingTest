/**
 * kakao.kakao3.java
 */
package kakao;

import java.util.Arrays;
import java.util.Stack; 

public class kakao3 {
	
	public String solution(int n, int t, int m, String[] timetable) {

        String answer = "";
        
        //timetable MM 바꾸기
        int[] arr = new int[timetable.length];
        
        for(int i=0; i<timetable.length; i++){            
            int timeMM = Integer.parseInt(timetable[i].substring(0,2))*60;
            int timeSS = Integer.parseInt(timetable[i].substring(3,5));                        
            
            arr[i] = timeMM+timeSS;    
        }
        
        //정렬
        Arrays.sort(arr);
        
        //timetable배열 스택에 넣기
        Stack<Integer> standTime = new Stack<>(); 
        
        for(int j=0; j<arr.length; j++){
            standTime.push(arr[j]);
        }
        
        int busTime = 540;
        
        //버스에 탑승될 크루 스택
        Stack<Integer> busCount = new Stack<>(); 

        int timeMM = 0;
        
        for(int k=0; k<n; k++){
            
            //버스 초기화(회차마다 새 버스이므로)
            busCount.clear();
            
            for(int l=0; l<standTime.size(); l++){
                
                if(busTime>=standTime.elementAt(l)){
                    
                    //자리있으면 태우기
                    if(busCount.size()<m && (standTime.elementAt(l) != 0) ){
                        
                        busCount.push(standTime.elementAt(l));
                        //standTime.remove(l);   
                        standTime.set(l, 0);
                        
                    }  
                    
                }       
            }    
            
            if(busCount.size()==m){    
                        
                //마지막 탑승자보다 1분 빠르게 오기
                timeMM = busCount.elementAt(busCount.size()-1)-1;

            //정원이 아닐때    
            }else{

                //버스 도착시간에 오기
                timeMM = busTime;

            }

            busTime += t;
            
        }
        
        //시간바꾸기 ex) 09:12
        if(Integer.toString(timeMM/60).length() == 1){
            answer += "0";
            answer += Integer.toString(timeMM/60);
        }else{
            answer += Integer.toString(timeMM/60);
        }

        answer += ":";

        if(Integer.toString(timeMM%60).length() == 1){
            answer += "0";
            answer += Integer.toString(timeMM%60);
        }else{
            answer += Integer.toString(timeMM%60);
        }

        return answer;
    }
}
