public class s9{
public static void solveHanoi(int n,char source,char auxiliary,char destination){
if(n==1){
System.out.println("Move disk 1 from"+source+"to"+destination);
return;
}
solveHanoi(n-1,source,destination,auxiliary);
System.out.println("Move disk 1 from"+source+"to"+destination);
solveHanoi(n-1,auxiliary,source,destination);
}
public static void main(String[] args){
int numdisks=4;
System.out.println("towers of Hanoi solution for"+numdisks);
solveHanoi(numdisks,'a','b','c');
}
}