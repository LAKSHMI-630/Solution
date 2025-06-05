public class s2{
public static void main(String[] args){
StringBuilder sb=new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("world");
String result=sb.toString();
System.out.println("concatenated string"+result);
String str="Hello";
System.out.println("individual characters:");
for(char c:str.toCharArray()){
System.out.println(c);
}
}
}
