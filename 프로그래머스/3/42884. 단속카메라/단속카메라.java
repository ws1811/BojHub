import java.util.*;
class Solution {
    public int solution(int[][] routes) 
    {
         int answer = 1;

        // 차량의 진출 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        // 첫 번째 차량의 진출 지점에 카메라 설치
        int cameraPos = routes[0][1];

        // 이후 차량들의 진입 지점과 현재 카메라 위치를 비교하여 새로운 카메라 설치 결정
        for (int i = 1; i < routes.length; i++) {
            if (cameraPos < routes[i][0]) {
                // 현재 카메라 위치보다 다음 차량의 진입 지점이 더 크면 새로운 카메라 설치
                answer++;
                cameraPos = routes[i][1];
            }
        }

        return answer;
    }
    
}