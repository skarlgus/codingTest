/**
 * kakao.kakao2.java
 */
package kakao;

import java.util.Stack;

public class kakao2 {
	
	public String solution(int n, int k, String[] cmd) {
        
        String answer = "";
        
        //z시 담아줄 스택 선언(push,pop을 통해 index를 담아줄 예정)
        Stack<Integer> zCmd = new Stack<>();
        
        //z,c로 인해 행이 삭제되고 추가되어 행의 전체 크기를 나타내기 위한 변수 선언
        int indexMaxSize = n;
        
        //문자열 쌓기 위한 변수 선언
        StringBuilder sBuilder = new StringBuilder();
        
        //수행 명령길이 만큼
        for(int i=0; i<cmd.length; i++){   
            
            //아래 이동
            if(cmd[i].substring(0,1).equals("D")){
                k=k+Integer.parseInt(cmd[i].substring(2));
                
            //위로 이동
            }else if(cmd[i].substring(0,1).equals("U")){
                k=k-Integer.parseInt(cmd[i].substring(2)); 
                
            //삭제
            }else if(cmd[i].substring(0,1).equals("C")){
                //스택에 값 담기
                zCmd.push(k);         
                //삭제로 인한 전체 행크기 -1         
                --indexMaxSize;
                //마지막행 삭제일 경우 포커스 되어있는 윗행 포커스
                if(k==indexMaxSize) k--; 

            //되돌리기
            }else if(cmd[i].substring(0,1).equals("Z")){            
                //되돌리기로 인한 전체 행크기 +1         
                indexMaxSize++;
                //되돌린행이 포커스되어있는 행보다 작은 경우 한칸 밀리게 되므로 +1
                if(zCmd.pop()<=k) k++;
                
            }   
        }

        //마지막 사이즈의 행크기 만큼 0 append
        for(int i=0; i<indexMaxSize; i++){
            sBuilder.append("O");
        }
        
        //스택 크기
        int sSize = zCmd.size();
        
        //스택 크기 만큼 추가(스택에는 z시 포커스되어있던 index가 담겨 있음)
        for(int i=0; i<sSize; i++){            
            sBuilder.insert(zCmd.pop(), "X");
        }
            
        answer=sBuilder.toString();
        
        return answer;
    }
}
