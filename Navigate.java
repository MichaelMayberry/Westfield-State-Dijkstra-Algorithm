import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Navigate
{
    HashMap<Character, Integer> letterToIndex;
    HashMap<Integer, Character> indexToLetter;
    HashMap<Character, String> letterToName;

    double [][] westfieldCampus = new double[][]
            {
                    //A
                    {0, 95.79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 79.01, 0, 0, 0},
                    //B
                    {95.79, 0, 190.96, 0, 238.31, 0, 242.48, 0, 408.65, 0, 302.84, 0, 339.75, 0, 226.02, 121.12, 0, 0, 0, 0, 0, 0, 145.58, 0, 0, 0},
                    //C
                    {0, 190.92 , 0, 0, 134.29, 0, 202.67, 0, 369.02, 0, 263.03, 0, 299.94, 0, 188.21, 153.42, 0, 0, 0, 0, 0, 0, 260.36, 0, 0, 0},
                    //D
                    {0, 0, 0, 0, 138.57, 0, 0, 284.11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //E
                    {0, 238.31, 134.29, 138.57, 0, 115.66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //F
                    {0, 0, 0, 0, 115.66, 0, 27.46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //G
                    {0, 242.48, 202.67, 0, 0, 27.46, 0, 0, 166.35, 0, 60.36, 0, 97.27, 0, 228.58, 193.79, 0, 0, 0, 0, 0, 0, 311.88, 0, 0, 0},
                    //H
                    {0, 0, 0, 284.11, 0, 0, 0, 0, 145, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //I
                    {0, 408.65, 369.02, 0, 0, 0, 166.35, 145, 0, 0, 226.71, 0, 263.62, 0, 394.93, 360.14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //J
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40.7, 56.76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    //K
                    {0, 302.84, 263.03, 0, 0, 0, 60.36, 0, 226.71, 40.7, 0, 50.76, 46.3, 0, 288.94, 254.15, 0, 0, 0, 0, 0, 0, 372.74, 0, 0, 0},
                    //L
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 56.76, 50.76, 0, 0, 128.94, 165.41, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //M
                    {0, 339.75, 299.94, 0, 0, 0, 97.72, 0, 263.62, 0, 46.3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    //N
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128.94, 0, 0, 165.41, 0, 0, 177.2, 0, 0, 231.85, 0, 0, 0, 0, 0},
                    //O
                    {0, 262.02, 188.21, 0, 0, 0, 228.58, 0, 394.93, 0, 288.94, 165.41, 0, 165.41, 0, 127.87, 0, 0, 0, 0, 0, 0, 282.51, 0, 0, 0},
                    //P
                    {0, 121.12, 153.42, 0, 0, 0, 193.79, 0, 360.14, 0, 254.15, 0, 0, 0, 127.87, 0, 0, 0, 0, 0, 0, 87.74, 0, 0, 0, 0},
                    //Q
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32.79, 43.56, 0, 0, 0, 0, 179.01, 0, 0, },
                    //R
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 177.2, 0, 0, 32.79, 0, 0, 59.04, 117.91, 0, 0, 0, 0, 0},
                    //S
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 43.56, 0, 0, 53.56, 0, 0, 0, 0, 202.08, 0},
                    //T
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 59.04, 53.56, 0, 49.16, 0, 0, 0, 0, 0},
                    //U
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 231.85, 0, 0, 0, 117.91, 0, 49.16, 0, 43.79, 0, 0, 0, 0},
                    //V
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 282.51, 87.74, 0, 0, 0, 0, 43.79, 0, 58.29, 0, 0, 211.27},
                    //W
                    {79.01, 145.58, 260.36, 0, 0, 0, 311.88, 0, 0, 0, 372.24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 58.29, 0, 0, 0, 0},
                    //X
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179.01, 0, 0, 0, 0, 0, 0, 0, 0, 195.97},
                    //Y
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 195.97, 0, 0},
                    //Z
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202.08, 0, 0, 211.27, 0, 0, 0, 0}
            };

    public Navigate()
    {
        letterToIndex = new HashMap<>()
        {{
            put('A', 0);
            put('B', 1);
            put('C', 2);
            put('D', 3);
            put('E', 4);
            put('F', 5);
            put('G', 6);
            put('H', 7);
            put('I', 8);
            put('J', 9);
            put('K', 10);
            put('L', 11);
            put('M', 12);
            put('N', 13);
            put('O', 14);
            put('P', 15);
            put('Q', 16);
            put('R', 17);
            put('S', 18);
            put('T', 19);
            put('U', 20);
            put('V', 21);
            put('W', 22);
            put('X', 23);
            put('Y', 24);
            put('Z', 25);

        }};

        indexToLetter = new HashMap<>()
        {{
            put(0, 'A');
            put(1, 'B');
            put(2, 'C');
            put(3, 'D');
            put(4, 'E');
            put(5, 'F');
            put(6, 'G');
            put(7, 'H');
            put(8, 'I');
            put(9, 'J');
            put(10, 'K');
            put(11, 'L');
            put(12, 'M');
            put(13, 'N');
            put(14, 'O');
            put(15, 'P');
            put(16, 'Q');
            put(17, 'R');
            put(18, 'S');
            put(19, 'T');
            put(20, 'U');
            put(21, 'V');
            put(22, 'W');
            put(23, 'X');
            put(24, 'Y');
            put(25, 'Z');
        }};

        letterToName = new HashMap<>(){{
            put('A', "University Hall");
            put('B', "Lammers Hall");
            put('C', "Courtney Hall");
            put('D', "Davis Hall");
            put('E', "New Hall");
            put('F', "Owl Cafe");
            put('G', "Wilson Academic Hall");
            put('H', "Commuter Lot 1");
            put('I', "New Science Academic Hall");
            put('J', "Bates Hall Entrance 1");
            put('K', "Bates Hall Entrance 2");
            put('L', "Parenzo Hall Entrance 1");
            put('M', "Parenzo Hall Entrance 2");
            put('N', "Scanlon Hall");
            put('O', "Bistro Opening");
            put('P', "Dining Commons");
            put('Q', "Apartments 2");
            put('R', "Apartments 1");
            put('S', "Apartments 3");
            put('T', "Dickinson Hall");
            put('U', "Maintenance Hall");
            put('V', "Dunkin Donuts");
            put('W', "Ely Hall");
            put('X', "Dower Center");
            put('Y', "South Lot Entrance");
            put('Z', "Commuter Lot 2");
        }};
    }



    public ArrayList<Node> shortestPath(double[][] graph, int nodes, char start, char end)
    {
        int startIndex = letterToIndex.get(start);
        int endIndex = letterToIndex.get(end);

       ArrayList<Boolean> visited = new ArrayList<>();
       ArrayList<Double> distance = new ArrayList<>();
       ArrayList<ArrayList<Node>> previous = new ArrayList<>();
       for (int i=0; i<nodes; i++)
       {
           visited.add(i, false);
           distance.add(i, Double.MAX_VALUE);
           previous.add(new ArrayList<Node>());
       }
       distance.set(startIndex,0.0);
       //add the starting node to the path
       previous.get(startIndex).add(new Node(startIndex, 0, indexToLetter.get(startIndex)));

       //uses min heap to keep the next node with the least distance at the top
       MinHeap mh = new MinHeap(nodes);
       //distance from start to itself is 0
       mh.insert(mh, new Node(startIndex, 0.0, indexToLetter.get(startIndex)));

       while(mh.size != 0)
       {
           //grabs the next lowest distance node from the heap
           Node current = mh.delete(mh);
           int curIndex = current.graphIndex;
           double curDistance = current.distance;
           visited.set(curIndex, true);

           //if a route to this node through other nodes is already less than the current distance then ignore
           if(distance.get(curIndex) < curDistance)
               continue;

           double[] curEdges = graph[curIndex];

           //loops through all the neighboring nodes of the current node
           for(int i=0; i<curEdges.length; i++)
           {
               if (visited.get(i) || curEdges[i] == 0)
                   continue;

               double newDistance = distance.get(curIndex) + curEdges[i];

               if (newDistance < distance.get(i))
               {
                   //if the distance to a node changes (becomes less), then update the path by copying the path up until the
                   //current node + the current node
                   ArrayList<Node> temp = new ArrayList<>(previous.get(curIndex));
                   temp.add(new Node(i, newDistance, indexToLetter.get(i)));
                   previous.set(i, temp);

                   distance.set(i, newDistance);
                   mh.insert(mh, new Node(i, newDistance, indexToLetter.get(i)));
               }
           }
       }

       //returns array (path) of nodes
        //these nodes' index can be extracted to be readable
        //additionally the very last node's distance attribute in this array is also the total shortest distance form start to end node
        return previous.get(endIndex);
    }

   public void run()
   {
       Scanner s = new Scanner(System.in);
       int option = -1;
       while(option != 0)
       {
           char start;
           do {
               System.out.print("Enter letter of starting destination (A-Z): ");
               start = s.next().charAt(0);
               start = Character.toUpperCase(start);
           }while(letterToIndex.get(start) == null);

           char end;
           do {
               System.out.print("Enter letter of ending destination (A-Z): ");
               end = s.next().charAt(0);
               end = Character.toUpperCase(end);
           }while(letterToIndex.get(end) == null);

           ArrayList<Node> path = shortestPath(westfieldCampus, westfieldCampus.length, start, end);

           //construct path string
           String pathStr = "\nThe shortest path from " + letterToName.get(path.get(0).letter) + "(" +
                   indexToLetter.get(path.get(0).graphIndex) + ")" + " to " +
                   letterToName.get(path.get(path.size()-1).letter) + "(" + indexToLetter.get(path.get(path.size()-1).graphIndex)
                   + ")" + ":\n";

           for(int i=0; i<path.size()-1; i++)
           {
               pathStr += letterToName.get(path.get(i).letter) + "(" + indexToLetter.get(path.get(i).graphIndex) +
                       ")" + " to ";
           }
           Node finalNode = path.get(path.size()-1);

           DecimalFormat df = new DecimalFormat("#.00");
           String finalNodeDistance = df.format(finalNode.distance);
           pathStr += letterToName.get(finalNode.letter) + "(" + indexToLetter.get(finalNode.graphIndex) + ")" +
                   " in " + finalNodeDistance + " meters.\n";


           System.out.println(pathStr);

           option = -1;
           boolean cont = true;
           while(cont)
           {
               try
               {
                   while(option !=0 && option != 1)
                   {
                       System.out.print("Enter 0 to exit or 1 to continue: ");
                       option = s.nextInt();
                       cont = false;
                   }
               } catch (InputMismatchException e) {
                   cont = true;
                   s.nextLine();
               }
           }
           System.out.println();
           s.nextLine();
       }
   }
}

