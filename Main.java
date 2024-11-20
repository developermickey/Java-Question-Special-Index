public class Main {

    public static int specialIndex(int A[]) {
        int N = A.length, c = 0;
        long[] pEven = new long[N];
        long[] pOdd = new long[N];
        long sumEven = 0;
        long sumOdd = 0;

        // Calculate prefix sum for even indices
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sumEven += A[i];
            }
            pEven[i] = sumEven;

            if (i % 2 == 1) {
                sumOdd += A[i];
            }
            pOdd[i] = sumOdd;
        }

        // Iterate through the array and check the condition
       for(int  i = 0; i<N; i++){
        long lEven = (i>0)? pEven[i-1] : 0;
        long lOdd = (i>0)? pOdd[i-1] : 0;

        long rEven = (i<N-1)? pOdd[N-1] - pOdd[i] : 0;
        long rOdd = (i<N-1)? pEven[N-1] - pEven[i] : 0;

        if(lEven + rOdd == rEven + lOdd){
          c++;
        }
       }

        return c;
    }

    public static void main(String[] args) {
        int[] A = {2,2,2,2,2,2,2};
        int a = specialIndex(A);
        System.out.println(a); 
    }
}
