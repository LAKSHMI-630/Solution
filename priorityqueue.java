import java.util.PriorityQueue;
public class priorityqueue{
public static void main(String[] args){
PriorityQueue<Integer> pq=new PriorityQueue<>();
pq.offer(30);
pq.offer(70);
pq.offer(20);
System.out.println("priorityqueue(min-Heap):");
while(!pq.isEmpty()){
System.out.println(pq.poll());
}
}
}