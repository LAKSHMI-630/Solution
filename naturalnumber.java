class naturalnumber{
static int natural(int n){
if(n==1){
return 1;
}
else{
return n+natural(n-1);
}
}
public static void main(String[] args){
int number=10;
int result=natural(number);
System.out.println("natural of"+number+"is"+result);
}
}
