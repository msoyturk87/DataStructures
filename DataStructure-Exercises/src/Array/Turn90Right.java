package Array;

public class Turn90Right {
    public static void main(String[] args) {

            // TODO Auto-generated method stub

        System.out.println("**** Turn 90 INPLACE  ******");
      // int [][] number={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
       int [][] number={{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};

        System.out.println(number.length);
            int t=number.length-1;
            int tempo =0;
            int len=t;
            int lent=t;
            int rest=number.length%2;  // to control odd or even

        System.out.println("Before");
        for (int i = 0; i < number.length; i++) {
            for (int k = 0; k < number.length; k++) {
                System.out.print(number[i][k]+" ");
            }
            System.out.println();
        }

            for (int i = 0; i <number.length/2; i++) {

                for (int j = i; j < lent; j++) {

                    tempo=number[i][j];
                    number[i][j]=number[t-j][i];
                    number[t-j][i]=number[len][t-j];
                    number[len][t-j]=number[j][len];
                    number[j][len]=tempo;

                }
                len--;
                lent=lent-2+rest;
            }
        System.out.println("After");

            for (int i = 0; i < number.length; i++) {
                for (int k = 0; k < number.length; k++) {
                    System.out.print(number[i][k]+" ");
                }
                System.out.println();
            }

        System.out.println("IN PLACE TURN WITH NEW ARRAY  ");

        int [][] numbers={{1,2,3},{4,5,6},{7,8,9}};
        int [][] newOne=new int[3][3];

        int n=numbers.length-1;

            for (int i = 0; i <= n; i++) {

                for (int j=0; j<=n; j++) {

                    newOne[i][j]=numbers[n-j][i];

                    System.out.print(newOne[i][j]+" ");

            }
                System.out.println();
        }



    }

    }

