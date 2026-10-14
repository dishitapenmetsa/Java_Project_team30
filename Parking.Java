import java.util.Scanner;
class Parking {
 static Scanner sc=new Scanner(System.in);
 static String vehicle[][]=new String[2][3];
 static int hours[][]=new int[2][3];
 static void park(){
  System.out.print("Vehicle: "); String v=sc.next();
  System.out.print("Hours: "); int h=sc.nextInt();
  if(h<=0){System.out.println("Invalid hours");return;}
  for(int i=0;i<2;i++) for(int j=0;j<3;j++)
   if(vehicle[i][j]==null){
    vehicle[i][j]=v;hours[i][j]=h;System.out.println("Slot "+(i+1)+"-"+(j+1));return;
   }
  System.out.println("Parking Full");
 }
 static void remove(){
  System.out.print("Vehicle: "); String v=sc.next(); int i=0;
  while(i<2){int j=0;
   while(j<3){if(v.equals(vehicle[i][j])){
    String type;
    if(hours[i][j]<=2) type="Short";
    else if(hours[i][j]<=5) type="Medium";
    else type="Long";
    System.out.println(type+" Parking");
    System.out.println("Fee = "+hours[i][j]*50);
    vehicle[i][j]=null;hours[i][j]=0;return;} j++;}
   i++;
  }
  System.out.println("Not Found");
 }
 static void status(){
  for(int i=0;i<2;i++){System.out.print("Floor "+(i+1)+": ");
   for(int j=0;j<3;j++) System.out.print(vehicle[i][j]==null?"Empty ":"Occupied ");
   System.out.println();
  }
 }
 public static void main(String[] args){
  int ch;
  do{
   System.out.println("1.Park 2.Remove 3.Status 4.Exit"); ch=sc.nextInt();
   switch(ch){
    case 1:park();break;
    case 2:remove();break;
    case 3:status();break;
    case 4:System.out.println("Thank You");break;
    default:System.out.println("Invalid");
   }
  }while(ch!=4);
 }
}