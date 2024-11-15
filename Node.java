public class Node
{
    int graphIndex;
    char letter;
    double distance;

    public Node(int graphIndex, double distance, char letter)
    {
        this.graphIndex = graphIndex;
        this.distance = distance;
        this.letter = letter;
    }
}
